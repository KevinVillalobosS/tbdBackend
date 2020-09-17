package com.tbd.tbd1.model;

import java.awt.*;

public class Volunteer {

    private int id;
    private String name;
    private Float x;
    private Float y;

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Volunteer(){}

    public Volunteer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Volunteer(String name) {
        this.name = name;
    }

    public int getIdVolunteer() {
        return id;
    }

    public void setIdVolunteer(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
