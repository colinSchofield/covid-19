package com.idk.covid19.web;

import com.idk.covid19.model.Region;
import com.idk.covid19.model.daily.Daily;
import com.idk.covid19.model.weekly.TableDetails;
import com.idk.covid19.service.RapidApiService;
import com.idk.covid19.util.CountryFlagEmojiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("${covid19.api-version}")
public class Covid19Controller {

    public final static Logger LOG = LoggerFactory.getLogger(Covid19Controller.class);

    @Autowired
    private RapidApiService rapidApiService;

    @Autowired
    private CountryFlagEmojiUtil flag;

    @GetMapping("/list/daily")
    @ResponseStatus(HttpStatus.OK)
    public Daily getCovid19DailySummary() {
        return rapidApiService.getCovid19DailySummary();
    }

    @GetMapping("/list/monthly/{region}")
    @ResponseStatus(HttpStatus.OK)
    public TableDetails getCovid19MonthlyHistory(@PathVariable String region) {
        return rapidApiService.getCovid19MonthlyHistory(region);
    }

    @GetMapping("/list/regions")
    @ResponseStatus(HttpStatus.OK)
    public List<Region> getListOfRegions() {
        return flag.getRegionList();
    }
}