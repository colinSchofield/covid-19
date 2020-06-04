package com.idk.covid19.model.daily;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Cases {

    @JsonProperty("new")
    private String newCases;
    private Integer active;
    private Integer critical;
    private Integer recovered;
    private Integer total;

    public Cases() {
    }

    public Cases(String newCases, Integer active, Integer critical, Integer recovered, Integer total) {
        this.newCases = newCases;
        this.active = active;
        this.critical = critical;
        this.recovered = recovered;
        this.total = total;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}

