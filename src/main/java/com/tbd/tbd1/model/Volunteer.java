package com.tbd.tbd1.model;

public class Volunteer {

    private int id;
    private String name;

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
