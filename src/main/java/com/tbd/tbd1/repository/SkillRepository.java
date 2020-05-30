package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Skill;

public interface SkillRepository {
    int saveSkill(Skill skill);
    boolean deleteSkill(Skill skill);
    Skill getSkillById(int id);
    int updateSkill(Skill skill);
}
