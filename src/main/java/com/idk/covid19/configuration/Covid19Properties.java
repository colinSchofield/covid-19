package com.idk.covid19.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("covid19")
@Component
public class Covid19Properties {

    private String apiVersion;
    private String excludeRegion;
    private final AdminAccess adminAccess = new AdminAccess();
    private final RapidApi rapidApi = new RapidApi();

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public AdminAccess getAdminAccess() {
        return adminAccess;
    }

    public RapidApi getRapidApi() {
        return rapidApi;
    }

    public String getExcludeRegion() {
        return excludeRegion;
    }

    public void setExcludeRegion(String excludeRegion) {
        this.excludeRegion = excludeRegion;
    }

    public static class AdminAccess {

        private String name;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class RapidApi {

        private String apiHost;
        private String apiHost2;
        private String apiKey;
        private String covid19Summary;
        private String weeklyHistory;

        public String getApiHost() {
            return apiHost;
        }

        public void setApiHost(String apiHost) {
            this.apiHost = apiHost;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public String getCovid19Summary() {
            return covid19Summary;
        }

        public void setCovid19Summary(String covid19Summary) {
            this.covid19Summary = covid19Summary;
        }

        public String getWeeklyHistory() {
            return weeklyHistory;
        }

        public void setWeeklyHistory(String weeklyHistory) {
            this.weeklyHistory = weeklyHistory;
        }

        public String getApiHost2() {
            return apiHost2;
        }

        public void setApiHost2(String apiHost2) {
            this.apiHost2 = apiHost2;
        }
    }
}