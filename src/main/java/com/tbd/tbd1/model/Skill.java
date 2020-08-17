package com.tbd.tbd1.model;

public class Skill {
    private int id;
    private String description;

    public Skill() {}

    public Skill(int id_skill, String description) {
        this.id = id;
        this.description = description;
    }

    public int getIdSkill() { return id; }
    public void setIdSkill(int idSkill) { this.id = idSkill; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
