package com.idk.covid19.web;

import com.idk.covid19.configuration.Covid19Properties;
import com.idk.covid19.model.Region;
import com.idk.covid19.model.daily.*;
import com.idk.covid19.model.weekly.TableDetails;
import com.idk.covid19.service.RapidApiService;
import com.idk.covid19.util.CountryFlagEmojiUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.Base64Utils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = Covid19Controller.class)
class Covid19ControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    RapidApiService rapidApiService;

    @MockBean(name = "summaryClient")
    private WebClient summaryClient;

    @MockBean(name = "historyClient")
    private WebClient historyClient;

    @MockBean
    private CountryFlagEmojiUtil flag;

    @MockBean
    private Covid19Properties properties;

    @Test
    public void testGetCovid19DailySummary() {
        // Given
        Daily daily = new Daily();
        daily.setResults(2);
        Cases cases = new Cases(null, 70, 5, 80000, 81000);
        Deaths deaths = new Deaths(null, 3000);
        Tests tests = new Tests(null);
        Cases cases2 = new Cases(null, 10000, 7000, 90000, 91000);
        Deaths deaths2 = new Deaths(null, 6000);
        Tests tests2 = new Tests(null);
        CountryInfo country1 = new CountryInfo("China", cases, deaths, tests, "2020-07-07", "2020-07-07T20:00:07+00:00");
        CountryInfo country2 = new CountryInfo("USA", cases2, deaths2, tests2, "2020-07-07", "2020-07-07T20:00:07+00:00");
        daily.setResponse(Arrays.asList(country1, country2));
        when(rapidApiService.getCovid19DailySummary()).thenReturn(Mono.just(daily));
        // When
        webClient.get()
                .uri("/api/1.0//list/daily")
                .header("Authorization", "Basic " + Base64Utils
                        .encodeToString(("user" + ":" + "password").getBytes()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.results", is(daily.getResults()))
                .hasJsonPath().jsonPath("$.response.[0].country", daily.getResponse().get(0).getCountry())
                .hasJsonPath().jsonPath("$.response.[1].country", daily.getResponse().get(1).getCountry())
                .hasJsonPath().jsonPath("$.response.[0].cases.active", daily.getResponse().get(0).getCases().getActive())
                .hasJsonPath().jsonPath("$.response.[1].cases.active", daily.getResponse().get(1).getCases().getActive());
        // Then
        verify(rapidApiService, times(1)).getCovid19DailySummary();
    }

    @Test
    public void testGetCovid19MonthlyHistory() {
        // Given
        final String region = "USA";
        String[] labels = {"1", "2"};
        Integer[] newCases = {5, 7};
        Integer[] deaths = {1, 2};
        TableDetails tableDetails = new TableDetails("X", labels, newCases, deaths);
        when(rapidApiService.getCovid19MonthlyHistory(region)).thenReturn(Mono.just(tableDetails));
        // When
        webClient.get()
                .uri("/api/1.0//list/monthly/" + region)
                .header("Authorization", "Basic " + Base64Utils
                        .encodeToString(("user" + ":" + "password").getBytes()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.flag", is(tableDetails.getFlag()))
                .hasJsonPath().jsonPath("$.labels[0]", tableDetails.getLabels()[0])
                .hasJsonPath().jsonPath("$.newCases[0]", tableDetails.getNewCases()[0])
                .hasJsonPath().jsonPath("$.deaths[0]", tableDetails.getDeaths()[0]);
        // Then
        verify(rapidApiService, times(1)).getCovid19MonthlyHistory(region);
    }

    @Test
    public void testGetListOfRegions() {
        // Given
        Region region1 = new Region("Australia", "Australia", "A", "AU");
        Region region2 = new Region("New-Zealand", "New Zealand", "N", "NZ");
        List<Region> regions = Arrays.asList(region1, region2);
        // When
        webClient.get()
                .uri("/api/1.0//list/regions/")
                .header("Authorization", "Basic " + Base64Utils
                        .encodeToString(("user" + ":" + "password").getBytes()))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0]['key']", is(regions.get(0).getKey()));
    }
}