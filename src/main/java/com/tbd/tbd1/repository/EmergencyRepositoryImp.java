package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Emergency;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class EmergencyRepositoryImp implements EmergencyRepository{


    @Autowired
    private Sql2o sql2o;

    @Override
    public int saveEmergency(Emergency emergency){
        System.out.println(emergency.getName());
        try (Connection connection = sql2o.open()){
            int newId = (int) connection.createQuery("INSERT INTO skills(description) VALUES (:description)", true)
                    .addParameter("description", emergency.getName())
                    .executeUpdate().getKey();
            emergency.setIdEmergency(newId);
            return newId;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    @Override
    public boolean deleteEmergency(Emergency emergency){ return false; }

    @Override
    public Emergency getEmergencyById(int id){
        String sql = "SELECT name FROM emergency WHERE id_emergency = "+id;
        Emergency emergency = new Emergency();
        try (Connection connection = sql2o.open()){
            String name = connection.createQuery(sql).executeScalar(String.class);
            if (name != null){
                emergency.setIdEmergency(id);
                emergency.setName(name);
                return emergency;
            }
            return null;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public int updateEmergency(Emergency emergency){ return 0; }
}
