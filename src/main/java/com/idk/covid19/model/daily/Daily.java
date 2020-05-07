package com.idk.covid19.model.daily;

import java.util.List;

public class Daily {
    private List<String> parameters;
    private List<String> errors;
    private Integer results;
    private List<CountryInfo> response;

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
