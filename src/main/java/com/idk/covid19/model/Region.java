package com.idk.covid19.model;

public class Region {

    private String key;
    private String location;
    private String countryCode;
    private String flag;

    public Region(String key, String location, String countryCode, String flag) {
        this.key = key;
        this.location = location;
        this.countryCode = countryCode;
        this.flag = flag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
