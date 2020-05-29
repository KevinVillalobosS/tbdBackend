package com.tbd.tbd1.model;

public class Volunteer {

    private int idVolunteer;
    private String name;

    public Volunteer(){}

    public Volunteer(int idVolunteer, String name) {
        this.idVolunteer = idVolunteer;
        this.name = name;
    }

    public Volunteer(String name) {
        this.name = name;
    }

    public int getIdVolunteer() {
        return idVolunteer;
    }

    public void setIdVolunteer(int idVolunteer) {
        this.idVolunteer = idVolunteer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
