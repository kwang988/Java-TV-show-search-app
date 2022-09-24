package com.kenzie.app.tvmaze;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Network {
    @JsonProperty("officialSite")
    private String officialSite;
    @JsonProperty("country")
    private Country country;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private int id;

    public String getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(String officialSite) {
        this.officialSite = officialSite;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
