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

        private String userName;
        private String userPassword;
        private String adminName;
        private String adminPassword;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public String getAdminName() {
            return adminName;
        }

        public void setAdminName(String adminName) {
            this.adminName = adminName;
        }

        public String getAdminPassword() {
            return adminPassword;
        }

        public void setAdminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
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