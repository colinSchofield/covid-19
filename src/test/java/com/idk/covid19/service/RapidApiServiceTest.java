package com.idk.covid19.service;

import com.idk.covid19.model.weekly.DailyHistory;
import com.idk.covid19.model.weekly.TableDetails;
import com.idk.covid19.model.weekly.Weekly;
import com.idk.covid19.util.CountryFlagEmojiUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RapidApiServiceTest {

    private final static SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("dd-MM-yyyy");

    private RapidApiService testService = new RapidApiService();
    private final CountryFlagEmojiUtil flag = new CountryFlagEmojiUtil();

    @BeforeEach
    public void setup() {
        ReflectionTestUtils.setField(testService, "flag", flag);
    }

    @Test
    void oneDailyElementDuringTheWeek() throws ParseException {

        // Given
        Weekly weekly = new Weekly();
        DailyHistory dh = new DailyHistory();
        dh.setDeaths(30);
        dh.setTotalCases(300);
        DailyHistory dh2 = new DailyHistory();
        dh2.setDeaths(20);
        dh2.setTotalCases(250);
        weekly.setData(new HashMap<>());
        weekly.getData().put(FORMAT_DATE.parse("06-05-2020"), dh);
        weekly.getData().put(FORMAT_DATE.parse("05-05-2020"), dh2);

        // When
        TableDetails td = testService.getCalculateDeltasBetweenDays(weekly, "Uk");

        // Then
        assertNotNull(td, "Value returned must not be null");
        assertTrue(td.getFlag().equals("🇬🇧"), "Flag type is set to be Uk flag");
        assertTrue(td.getLabels().length == 1 && td.getLabels()[0].equals("6"), "Label must give the day");
        assertTrue(td.getNewCases().length == 1 && td.getNewCases()[0] == 50, "NewCases must provide a delta");
        assertTrue(td.getDeaths().length == 1 && td.getDeaths()[0] == 10, "Deaths must provide a delta");
    }

    @Test
    void threeDailyElementDuringTheWeek() throws ParseException {

        // Given
        Weekly weekly = new Weekly();
        DailyHistory dh = new DailyHistory();
        dh.setDeaths(30);
        dh.setTotalCases(300);
        DailyHistory dh2 = new DailyHistory();
        dh2.setDeaths(25);
        dh2.setTotalCases(240);
        DailyHistory dh3 = new DailyHistory();
        dh3.setDeaths(10);
        dh3.setTotalCases(200);
        weekly.setData(new TreeMap<>(Collections.reverseOrder()));
        weekly.getData().put(FORMAT_DATE.parse("06-05-2020"), dh);
        weekly.getData().put(FORMAT_DATE.parse("05-05-2020"), dh2);
        weekly.getData().put(FORMAT_DATE.parse("04-05-2020"), dh3);

        // When
        TableDetails td = testService.getCalculateDeltasBetweenDays(weekly, "Uk");

        // Then
        assertNotNull(td, "Value returned must not be null");
        assertTrue(td.getFlag().equals("🇬🇧"), "Flag type is set to be Uk flag");
        assertTrue(td.getLabels().length == 2 && td.getLabels()[0].equals("5") &&
                td.getLabels()[1].equals("6"), "Label must give the day");
        assertTrue(td.getNewCases().length == 2 && td.getNewCases()[0] == 40 &&
                td.getNewCases()[1] == 60, "NewCases must provide a delta");
        assertTrue(td.getDeaths().length == 2 && td.getDeaths()[0] == 15 &&
                td.getDeaths()[1] == 5, "Deaths must provide a delta");
    }
}