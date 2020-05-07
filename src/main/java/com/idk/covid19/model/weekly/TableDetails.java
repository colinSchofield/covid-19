package com.idk.covid19.model.weekly;

public class TableDetails {
    private String flag;
    private String[] labels;
    private Integer[] newCases;
    private Integer[] deaths;

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Integer[] getNewCases() {
        return newCases;
    }

    public void setNewCases(Integer[] newCases) {
        this.newCases = newCases;
    }

    public Integer[] getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer[] deaths) {
        this.deaths = deaths;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
