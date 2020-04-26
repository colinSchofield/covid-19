package com.idk.covid19.web;

import com.idk.covid19.model.Covid19Results;
import com.idk.covid19.service.RapidApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("${covid19.api-version}")
public class Covid19Controller {

    public final static Logger LOG = LoggerFactory.getLogger(Covid19Controller.class);

    @Autowired
    private RapidApiService rapidApiService;

    @GetMapping("/list/covid19")
    Mono<Covid19Results> getCovid19Stats() {

        return rapidApiService.getCovid19Stats();
    }
}
