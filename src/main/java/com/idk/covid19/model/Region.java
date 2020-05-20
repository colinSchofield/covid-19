package com.idk.covid19.model;

public class Region {

    private String key;
    private String location;
    private String flag;

    public Region(String key, String location, String flag) {
        this.key = key;
        this.location = location;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
