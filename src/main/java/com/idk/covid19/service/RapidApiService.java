package com.idk.covid19.service;

import com.idk.covid19.model.Covid19Results;
import com.idk.covid19.web.Covid19Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.logging.Level;

@Service
@CacheConfig(cacheNames = { "rapidApi"})
public class RapidApiService {

    private static final Logger LOG = LoggerFactory.getLogger(RapidApiService.class);

    @Autowired
    private WebClient rapidApiClient;

    @Cacheable
    public Mono<Covid19Results> getCovid19Stats() {

        LOG.debug("About to obtain Covid-19 statistics from Rapid API WebService");
        Mono<Covid19Results> response = rapidApiClient
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Covid19Results.class)
                .log(Covid19Controller.class.getName(), Level.FINE);

        LOG.debug("Call to obtain the results has been submitted..");
        return response;
    }
}
