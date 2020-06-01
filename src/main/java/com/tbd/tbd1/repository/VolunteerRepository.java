package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Volunteer;

import java.util.List;

public interface VolunteerRepository {
    int saveVolunteer(Volunteer volunteer);
    boolean deleteVolunteer(Volunteer volunteer);
    Volunteer getVolunteerById(int id);
    int updateVolunteer(Volunteer volunteer);
    List<Volunteer> getAllVolunteers();
}
