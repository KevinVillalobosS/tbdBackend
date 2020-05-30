package com.tbd.tbd1.model;

public class Emergency {
    private int idEmergency;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private int idInstitution;

    public Emergency(){}

    public Emergency(int idEmergency, String name, String description, String startDate, String endDate, int idInstitution){
        this.idEmergency = idEmergency;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idInstitution = idInstitution;
    }

    public int getIdEmergency() { return idEmergency; }
    public void setIdEmergency(int idEmergency) {this.idEmergency = idEmergency; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public int getIdInstitution() { return idInstitution; }
    public void setIdInstitution(int idInstitution) { this.idInstitution = idInstitution; }
}
