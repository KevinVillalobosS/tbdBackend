package com.tbd.tbd1.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskRepositoryImp implements TaskRepository {

    @Autowired
    private Sql2o sql2o;

    public List<Integer> getTasksByEmergency(int idEmergency) {
            String sql = "SELECT id_volunteer FROM volunteer_skill WHERE id_skill = "+idEmergency;
            try (Connection connection = sql2o.open()){
                List<Integer> id_volunteers = connection.createQuery(sql).executeScalarList(int.class);
                return id_volunteers;
            }catch(Exception exception){
                System.out.println(exception.getMessage());
                return null;
            }


    }
}
