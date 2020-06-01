package com.tbd.tbd1.controller;

import com.tbd.tbd1.repository.TaskRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepositoryImp taskRepositoryImp;

    public List<Integer> getTasksByEmergency(int idEmergency) {
        return this.taskRepositoryImp.getTasksByEmergency(idEmergency);

    }


}
