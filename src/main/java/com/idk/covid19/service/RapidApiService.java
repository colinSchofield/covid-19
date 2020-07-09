package com.idk.covid19.service;

import com.idk.covid19.configuration.Covid19Properties;
import com.idk.covid19.model.daily.CountryInfo;
import com.idk.covid19.model.daily.Daily;
import com.idk.covid19.model.weekly.DailyHistory;
import com.idk.covid19.model.weekly.TableDetails;
import com.idk.covid19.model.weekly.Weekly;
import com.idk.covid19.util.CountryFlagEmojiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

@Service
@CacheConfig(cacheNames = {"rapidApi"})
public class RapidApiService {

    private static final Logger LOG = LoggerFactory.getLogger(RapidApiService.class);
    private static final SimpleDateFormat LONG_DAY_IN_MONTH = new SimpleDateFormat("d");
    private static final String RAPID_API_HOST = "x-rapidapi-host";
    private static final String RAPID_API_KEY = "x-rapidapi-key";

    @Autowired
    private RestTemplate summaryClient;

    @Autowired
    private RestTemplate historyClient;

    @Autowired
    private CountryFlagEmojiUtil flag;

    @Autowired
    private Covid19Properties properties;


    @Cacheable
    public Daily getCovid19DailySummary() {

        LOG.debug("About to obtain Covid-19 daily summary from Rapid API WebService");

        HttpHeaders headers = new HttpHeaders();
        headers.add(RAPID_API_HOST, properties.getRapidApi().getApiHost());
        headers.add(RAPID_API_KEY, properties.getRapidApi().getApiKey());
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Daily> responseObj = summaryClient.exchange(properties.getRapidApi().getCovid19Summary(),
                HttpMethod.GET, entity, Daily.class);
        if (responseObj.getStatusCode().equals(HttpStatus.OK) && responseObj.getBody() != null) {
            return decorateCountry(filterOutNonCountryRegions(responseObj.getBody()));
        } else {
            LOG.warn("Error reading from WebService");
            throw new IllegalStateException("Error accessing WebService: " + responseObj.getStatusCodeValue());
        }
    }

    private Daily filterOutNonCountryRegions(Daily daily) {
        List<CountryInfo> response = daily
                .getResponse()
                .stream()
                .filter(region -> !region.getCountry().matches(properties.getExcludeRegion()))
                .collect(Collectors.toList());
        daily.setResponse(response);
        return daily;
    }

    private Daily decorateCountry(Daily daily) {
        List<CountryInfo> response = daily
                .getResponse()
                .stream()
                .map(countryInfo ->
                {
                    countryInfo.setDecoratedCountry(flag.getEmojiForCountry(countryInfo.getCountry()) + " " + countryInfo.getCountry());
                    return countryInfo;
                })
                .collect(Collectors.toList());
        daily.setResponse(response);
        return daily;
    }

    @Cacheable
    public TableDetails getCovid19MonthlyHistory(String region) {

        LOG.debug("About to obtain Covid-19 monthly history from Rapid API WebService");

        HttpHeaders headers = new HttpHeaders();
        headers.add(RAPID_API_HOST, properties.getRapidApi().getApiHost2());
        headers.add(RAPID_API_KEY, properties.getRapidApi().getApiKey());
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Weekly> responseObj = historyClient.exchange(properties.getRapidApi().getWeeklyHistory() +
                        "?region=" + region,
                        HttpMethod.GET,
                        entity,
                        Weekly.class);

        LOG.info("responseObj received!");
        LOG.info("values HttpStatus {}", responseObj.getStatusCodeValue());
        LOG.info("values body {}", responseObj.getBody());
        LOG.info("region {}", region);


        if (responseObj.getStatusCode().equals(HttpStatus.OK) && responseObj.getBody() != null) {
            return getCalculateDeltasBetweenDays(responseObj.getBody(), region);
        } else {
            LOG.warn("Error reading from WebService");
            throw new IllegalStateException("Error accessing WebService: " + responseObj.getStatusCodeValue());
        }
    }

    protected TableDetails getCalculateDeltasBetweenDays(Weekly weekly, String region) {

        List<String> labels = weekly.
                getData().
                keySet().
                stream().
                map(this::getDayInMonth).
                collect(Collectors.toList());
        labels.remove(labels.size() - 1);

        Iterator<DailyHistory> it = weekly.getData().values().iterator();
        List<Integer> newCases = new ArrayList<>();
        List<Integer> deaths = new ArrayList<>();
        DailyHistory first = it.next();
        while (it.hasNext()) {
            DailyHistory second = it.next();
            newCases.add(abs(first.getTotalCases() - second.getTotalCases()));
            deaths.add(abs(first.getDeaths() - second.getDeaths()));
            first = second;
        }

        Collections.reverse(labels);
        Collections.reverse(newCases);
        Collections.reverse(deaths);
        TableDetails td = new TableDetails();
        td.setFlag(flag.getEmojiForCountry(region));
        td.setLabels(labels.toArray(new String[0]));
        td.setNewCases(newCases.toArray(new Integer[0]));
        td.setDeaths(deaths.toArray(new Integer[0]));

        return td;
    }

    private String getDayInMonth(Date date) {
        return LONG_DAY_IN_MONTH.format(date);
    }
}
