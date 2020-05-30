package com.tbd.tbd1.controller;

import com.tbd.tbd1.model.Skill;
import com.tbd.tbd1.repository.SkillRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class SkillController {

    @Autowired
    private SkillRepositoryImp skillRepositoryImp;

    @PostMapping("/skill/new")
    public int saveSkill(@RequestBody Skill skill){
        int newId = this.skillRepositoryImp.saveSkill(skill);
        return newId;
    }

    @GetMapping("/skill/{id}")
    public Skill saveSkill(@PathVariable("id") int id){
        Skill skill = this.skillRepositoryImp.getSkillById(id);
        return skill;
    }

}
