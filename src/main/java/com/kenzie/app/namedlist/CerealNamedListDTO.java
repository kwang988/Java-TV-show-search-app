package com.kenzie.app.namedlist;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CerealNamedListDTO {

    @JsonProperty("cereals")
    private List<Cereals> cereals;

    public List<Cereals> getCereals() {
        return cereals;
    }

    public void setCereals(List<Cereals> cereals) {
        this.cereals = cereals;
    }
}
