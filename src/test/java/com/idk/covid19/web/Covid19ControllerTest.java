package com.idk.covid19.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idk.covid19.configuration.Covid19Properties;
import com.idk.covid19.model.Region;
import com.idk.covid19.model.daily.*;
import com.idk.covid19.model.weekly.TableDetails;
import com.idk.covid19.service.RapidApiService;
import com.idk.covid19.util.CountryFlagEmojiUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Covid19Controller.class)
public class Covid19ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RapidApiService rapidApiService;

    @MockBean
    private CountryFlagEmojiUtil flag;

    @MockBean
    private Covid19Properties properties;

    @MockBean
    private UserDetailsService userDetailsService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetCovid19DailySummary() throws Exception {
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
        when(rapidApiService.getCovid19DailySummary()).thenReturn(daily);
        String jsonAsText = mapper.writeValueAsString(daily);
        // Then Expect
        mvc.perform(get("/api/1.0/list/daily")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonAsText));

        // And
        verify(rapidApiService, times(1)).getCovid19DailySummary();
    }

    @Test
    public void testGetCovid19MonthlyHistory() throws Exception {
        // Given
        final String region = "USA";
        String[] labels = {"1", "2"};
        Integer[] newCases = {5, 7};
        Integer[] deaths = {1, 2};
        TableDetails tableDetails = new TableDetails("X", labels, newCases, deaths);
        when(rapidApiService.getCovid19MonthlyHistory(region)).thenReturn(tableDetails);
        String jsonAsText = mapper.writeValueAsString(tableDetails);
        // Then Expect
        mvc.perform(get("/api/1.0/list/monthly/" + region)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonAsText));
        // And
        verify(rapidApiService, times(1)).getCovid19MonthlyHistory(region);
    }

    @Test
    public void testGetListOfRegions() throws Exception {
        // Given
        Region region1 = new Region("Australia", "Australia", "A", "AU");
        Region region2 = new Region("New-Zealand", "New Zealand", "N", "NZ");
        List<Region> regions = Arrays.asList(region1, region2);
        when(flag.getRegionList()).thenReturn(regions);
        String jsonAsText = mapper.writeValueAsString(regions);
        // Then Expect
        mvc.perform(get("/api/1.0/list/regions/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(jsonAsText));
        // And
        verify(flag, times(1)).getRegionList();
    }
}