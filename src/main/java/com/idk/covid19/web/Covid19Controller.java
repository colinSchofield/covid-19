package com.idk.covid19.web;

import com.idk.covid19.model.Region;
import com.idk.covid19.model.daily.Daily;
import com.idk.covid19.model.weekly.TableDetails;
import com.idk.covid19.service.RapidApiService;
import com.idk.covid19.util.CountryFlagEmojiUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("${covid19.api-version}")
@Api(description="Endpoint for obtaining Covid-19 statistical information for use by the react frontend.")
public class Covid19Controller {

    public final static Logger LOG = LoggerFactory.getLogger(Covid19Controller.class);

    @Autowired
    private RapidApiService rapidApiService;

    @Autowired
    private CountryFlagEmojiUtil flag;

    @GetMapping("/list/daily")
    @ApiOperation("Returns the statistical results of critical patients, daily deltas as well as the deaths caused by the disease over the past day.")
    public Mono<Daily> getCovid19DailySummary() {
        return rapidApiService.getCovid19DailySummary();
    }

    @GetMapping("/list/monthly/{region}")
    @ApiOperation("Returns the daily results for new cases and deaths over the past month for the chosen location.")
    @ApiParam("Region equates to a country in the world.")
    public Mono<TableDetails> getCovid19MonthlyHistory(@PathVariable String region) {
        return rapidApiService.getCovid19MonthlyHistory(region);
    }

    @GetMapping("/list/regions")
    @ApiOperation("Returns the list of regions (i.e. countries) and their emoji flags.")
    public Mono<List<Region>> getListOfRegions() {
        return flag.getRegionList();
    }
}