package com.tbd.tbd1.model;

public class Skill {
    private int idSkill;
    private String description;

    public Skill() {}

    public Skill(int idSkill, String description) {
        this.idSkill = idSkill;
        this.description = description;
    }

    public int getIdSkill() { return idSkill; }
    public void setIdSkill(int idSkill) { this.idSkill = idSkill; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
