package com.kenzie.app.tvmaze;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Previousepisode {
    @JsonProperty("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
