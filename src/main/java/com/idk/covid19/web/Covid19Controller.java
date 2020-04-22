package com.idk.covid19.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("${covid19.api-version}")
public class Covid19Controller {

    public final static Logger LOG = LoggerFactory.getLogger(Covid19Controller.class);

    @GetMapping("/list/users")
    Mono<String> getListOfUsers() {

        LOG.debug("Just a quick message for now..");
        return Mono.just("<h2>Language is a virus from outer space..</h2>");
    }
}
