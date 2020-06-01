package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Volunteer;

import java.util.List;

public interface VolunteerRepository {
    int saveVolunteer(Volunteer volunteer);
    boolean deleteVolunteer(Volunteer volunteer);
    Volunteer getVolunteerById(int id);
    int updateVolunteer(Volunteer volunteer);
    List<Volunteer> getAllVolunteers();

    int setSkill(int idVolunteer, int idSkill);
    public List<Integer> getBySkill(int idSkill);

    List<Volunteer> getVolunteers(List<Integer> ids);

    List<Integer> getByEmergency(int idEmergency);
}
