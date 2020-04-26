package com.idk.covid19.model;

import java.util.List;

public class Covid19Results {
    private String get;
    private List<String> parameters;
    private List<String> errors;
    private Integer results;
    private List<CountryInfo> response;

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<CountryInfo> getResponse() {
        return response;
    }

    public void setResponse(List<CountryInfo> response) {
        this.response = response;
    }
}
