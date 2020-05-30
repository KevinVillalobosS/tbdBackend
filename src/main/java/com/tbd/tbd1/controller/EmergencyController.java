package com.tbd.tbd1.controller;

import com.tbd.tbd1.model.Emergency;
import com.tbd.tbd1.repository.EmergencyRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class EmergencyController {

    @Autowired
    private EmergencyRepositoryImp emergencyRepositoryImp;

    @PostMapping("/emergency/new")
    public int saveEmergency(@RequestBody Emergency emergency) {
        int newId = this.emergencyRepositoryImp.saveEmergency(emergency);
        return newId;
    }

    @GetMapping("/emergency/{id}")
    public Emergency getEmergencyById(@PathVariable("id") int id) {
        Emergency emergency = this.emergencyRepositoryImp.getEmergencyById(id);
        return emergency;
    }
}
