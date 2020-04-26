package com.idk.covid19.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebServiceConfiguration {

    @Autowired
    Covid19Properties properties;

    @Bean("rapidApiClient")
    WebClient rapidApiClient(WebClient.Builder builder) {
        return
                builder
                        .baseUrl("https://covid-193.p.rapidapi.com/statistics")
                        .defaultHeaders(headers ->
                        {
                            headers.add("x-rapidapi-host", properties.getApiHost());
                            headers.add("x-rapidapi-key", properties.getApiKey());
                        }).build();
    }
}