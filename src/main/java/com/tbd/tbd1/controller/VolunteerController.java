package com.tbd.tbd1.controller;

import com.tbd.tbd1.model.Volunteer;
import com.tbd.tbd1.repository.VolunteerRepository;
import com.tbd.tbd1.repository.VolunteerRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VolunteerController {

    @Autowired
    private VolunteerRepositoryImp volunteerRepositoryImp;

    @PostMapping("/volunteer/new")
    public int saveVolunteer(@RequestBody Volunteer volunteer){
        int newId = this.volunteerRepositoryImp.saveVolunteer(volunteer);
        return newId;
    }

    @GetMapping("/volunteer/{id}")
    public Volunteer saveVolunteer(@PathVariable("id") int id){
        Volunteer volunteer = this.volunteerRepositoryImp.getVolunteerById(id);
        return volunteer;
    }

}
