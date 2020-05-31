package com.tbd.tbd1.model;

public class Volunteer {

    private int id_volunteer;
    private String name;

    public Volunteer(){}

    public Volunteer(int id_volunteer, String name) {
        this.id_volunteer = id_volunteer;
        this.name = name;
    }

    public Volunteer(String name) {
        this.name = name;
    }

    public int getIdVolunteer() {
        return id_volunteer;
    }

    public void setIdVolunteer(int idVolunteer) {
        this.id_volunteer = idVolunteer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
