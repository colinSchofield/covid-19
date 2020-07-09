package com.idk.covid19.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebServiceConfiguration {

    @Autowired
    Covid19Properties properties;

    @Bean("summaryClient")
    RestTemplate summaryClient(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean("historyClient")
    RestTemplate historyClient(RestTemplateBuilder builder) {
        return builder.build();
    }
}