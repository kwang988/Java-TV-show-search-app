package com.kenzie.app.single;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CerealDTO {
    //declare properties
    private int id;
    private String type;
    private String name;
    private String base;
    private double calories;
    private ArrayList<String> marshmallows;//canbe string[] also

    //declare methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public ArrayList<String> getMarshmallows() {
        return marshmallows;
    }

    public void setMarshmallows(ArrayList<String> marshmallows) {
        this.marshmallows = marshmallows;
    }
}
