package com.tbd.tbd1.controller;

import com.tbd.tbd1.model.Skill;
import com.tbd.tbd1.repository.SkillRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillRepositoryImp skillRepositoryImp;

    @PostMapping("/skill/new")
    @CrossOrigin(origins = "", allowedHeaders = "")
    public int saveSkill(@RequestBody Skill skill){
        int newId = this.skillRepositoryImp.saveSkill(skill);
        return newId;
    }

    @GetMapping("/skill/{id}")
    @CrossOrigin(origins = "", allowedHeaders = "")
    public Skill saveSkill(@PathVariable("id") int id){
        Skill skill = this.skillRepositoryImp.getSkillById(id);
        return skill;
    }

    @GetMapping("/skill/all")
    @CrossOrigin(origins = "", allowedHeaders = "")
    public List<Skill> getSkills() {
        List<Skill> skills = this.skillRepositoryImp.getAllSkills();
        return skills;
    }

    @GetMapping("/skill/update")
    @CrossOrigin(origins = "", allowedHeaders = "")
    public int updateSkill(@RequestBody Skill skill){
        int id = this.skillRepositoryImp.updateSkill(skill);
        return id;
    }

}
