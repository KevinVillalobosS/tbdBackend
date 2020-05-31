package com.tbd.tbd1.model;

public class Emergency {
    private int id_emergency;
    private String emergency_name;
    private String description;
    private String startdate;
    private String enddate;
    private int idInstitution;

    public Emergency(){}

    public Emergency(int id_emergency, String emergency_name, String description, String startdate, String enddate, int idInstitution){
        this.id_emergency = id_emergency;
        this.emergency_name = emergency_name;
        this.description = description;
        this.startdate = startdate;
        this.enddate = enddate;
        this.idInstitution = idInstitution;
    }

    public int getIdEmergency() { return id_emergency; }
    public void setIdEmergency(int idEmergency) {this.id_emergency = idEmergency; }

    public String getName() { return emergency_name; }
    public void setName(String name) { this.emergency_name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStartDate() { return startdate; }
    public void setStartDate(String startDate) { this.startdate = startDate; }

    public String getEndDate() { return enddate; }
    public void setEndDate(String endDate) { this.enddate = endDate; }

    public int getIdInstitution() { return idInstitution; }
    public void setIdInstitution(int idInstitution) { this.idInstitution = idInstitution; }
}
