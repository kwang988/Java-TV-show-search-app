package com.kenzie.app.tvmaze;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
