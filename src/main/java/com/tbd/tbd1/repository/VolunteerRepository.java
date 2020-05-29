package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Volunteer;

public interface VolunteerRepository {
    public int saveVolunteer(Volunteer volunteer);
    public boolean deleteVolunteer(Volunteer volunteer);
    public Volunteer getVolunteerById(int id);
    public int updateVolunteer(Volunteer volunteer);
}
