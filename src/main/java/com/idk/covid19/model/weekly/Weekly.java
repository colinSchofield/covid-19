package com.idk.covid19.model.weekly;

import java.util.Date;
import java.util.Map;

public class Weekly {

    private Integer status;
    private String type;
    private Map<Date, DailyHistory> data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<Date, DailyHistory> getData() {
        return data;
    }

    public void setData(Map<Date, DailyHistory> data) {
        this.data = data;
    }
}
