package com.tbd.tbd1.controller;

import com.tbd.tbd1.model.Volunteer;
import com.tbd.tbd1.repository.VolunteerRepository;
import com.tbd.tbd1.repository.VolunteerRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VolunteerController {

    @Autowired
    private VolunteerRepositoryImp volunteerRepositoryImp;
    private TaskController taskController;

    @PostMapping("/volunteer/new")
    @CrossOrigin(origins = "*", allowedHeaders = "")
    public int saveVolunteer(@RequestBody Volunteer volunteer){
        int newId = this.volunteerRepositoryImp.saveVolunteer(volunteer);
        return newId;
    }

    @GetMapping("/volunteer/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "")
    public Volunteer saveVolunteer(@PathVariable("id") int id){
        Volunteer volunteer = this.volunteerRepositoryImp.getVolunteerById(id);
        return volunteer;
    }

    @GetMapping("/volunteer/all")
    @CrossOrigin(origins = "*", allowedHeaders = "")
    public List<Volunteer> getVolunteers(){
        List<Volunteer> volunteers = this.volunteerRepositoryImp.getAllVolunteers();
        return volunteers;
    }

    @GetMapping("/volunteer/update")
    @CrossOrigin(origins = "*", allowedHeaders = "")
    public int updateVolunteer(@RequestBody Volunteer volunteer) {
        int id = this.volunteerRepositoryImp.updateVolunteer(volunteer);
        return id;
    }


    @PostMapping("/volunteer/addSkill/{idVolunteer}/{idSkill}")
    @CrossOrigin(origins = "*", allowedHeaders = "")
    public int setSkill( @PathVariable("idVolunteer") int idVolunteer, @PathVariable("idSkill")  int idSkill) {
        return this.volunteerRepositoryImp.setSkill(idVolunteer, idSkill);
    }

    @PostMapping("/volunteer/bySkill/{idSkill}")
    @CrossOrigin(origins = "*", allowedHeaders = "")
    public List<Volunteer> getVolunteersBySkill( @PathVariable("idSkill")  int idSkill) {
        List<Integer> ids = this.volunteerRepositoryImp.getBySkill(idSkill);
        List<Volunteer> volunteers = this.volunteerRepositoryImp.getVolunteers(ids);
        return volunteers;
    }

    @PostMapping("/volunteer/byEmergency/{idEmergency}")
    @CrossOrigin(origins = "*", allowedHeaders = "")
    public List<Volunteer> getVolunteersByEmergency( @PathVariable("idEmergency")  int idEmergency) {
        List<Integer> taskIds = this.taskController.getByEmergency(idEmergency);
        //List<Volunteer> volunteers = this.volunteerRepositoryImp.getVolunteers(idEmergency);
        return null;
    }

}
