package com.tbd.tbd1.repository;


import com.tbd.tbd1.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

@Repository
public class SkillRepositoryImp implements SkillRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int saveSkill(Skill skill){
        System.out.println(skill.getDescription());
        try (Connection connection = sql2o.open()){
            int newId = (int) connection.createQuery("INSERT INTO skills(description) VALUES (:description)", true)
                    .addParameter("description", skill.getDescription())
                    .executeUpdate().getKey();
            skill.setIdSkill(newId);
            return newId;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    @Override
    public boolean deleteSkill(Skill skill) { return false; }

    @Override
    public Skill getSkillById(int id){
        String sql = "SELECT description FROM skills WHERE id_skill = "+id;
        Skill skill = new Skill();
        try (Connection connection = sql2o.open()){
            String description = connection.createQuery(sql).executeScalar(String.class);
            if (description != null){
                skill.setIdSkill(id);
                skill.setDescription(description);
                return skill;
            }
            return null;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public int updateSkill(Skill skill) { return 0; }
}
