package com.idk.covid19.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebServiceConfiguration {

    @Autowired
    Covid19Properties properties;

    @Bean("summaryClient")
    WebClient summaryClient(WebClient.Builder builder) {
        return
                builder
                        .baseUrl(properties.getRapidApi().getCovid19Summary())
                        .defaultHeaders(headers ->
                        {
                            headers.add("x-rapidapi-host", properties.getRapidApi().getApiHost());
                            headers.add("x-rapidapi-key", properties.getRapidApi().getApiKey());
                        }).build();
    }

    @Bean("historyClient")
    WebClient historyClient(WebClient.Builder builder) {
        return
                builder
                        .baseUrl(properties.getRapidApi().getWeeklyHistory())
                        .defaultHeaders(headers ->
                        {
                            headers.add("x-rapidapi-host", properties.getRapidApi().getApiHost2());
                            headers.add("x-rapidapi-key", properties.getRapidApi().getApiKey());
                        }).build();
    }
}