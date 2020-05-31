package com.tbd.tbd1.model;

public class Skill {
    private int id_skill;
    private String description;

    public Skill() {}

    public Skill(int id_skill, String description) {
        this.id_skill = id_skill;
        this.description = description;
    }

    public int getIdSkill() { return id_skill; }
    public void setIdSkill(int idSkill) { this.id_skill = idSkill; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
