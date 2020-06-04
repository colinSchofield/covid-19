package com.idk.covid19.model.daily;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Deaths {
    @JsonProperty("new")
    private String newDeaths;
    private Integer total;

    public Deaths() {
    }

    public Deaths(String newDeaths, Integer total) {
        this.newDeaths = newDeaths;
        this.total = total;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
