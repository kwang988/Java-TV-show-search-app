package com.kenzie.app.tvsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Externals {
    @JsonProperty("imdb")
    private String imdb;
    @JsonProperty("thetvdb")
    private int thetvdb;
    @JsonProperty("tvrage")
    private int tvrage;

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public int getThetvdb() {
        return thetvdb;
    }

    public void setThetvdb(int thetvdb) {
        this.thetvdb = thetvdb;
    }

    public int getTvrage() {
        return tvrage;
    }

    public void setTvrage(int tvrage) {
        this.tvrage = tvrage;
    }
}
