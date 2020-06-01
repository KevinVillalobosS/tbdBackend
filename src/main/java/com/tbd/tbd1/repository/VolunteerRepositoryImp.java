package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class VolunteerRepositoryImp implements VolunteerRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int saveVolunteer(Volunteer volunteer) {
        System.out.println(volunteer.getName());
        try (Connection connection = sql2o.open()){
            int newId = (int) connection.createQuery("INSERT INTO volunteers(name) VALUES (:name)", true)
                    .addParameter("name", volunteer.getName())
                    .executeUpdate().getKey();
            volunteer.setIdVolunteer(newId);
            return newId;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    @Override
    public boolean deleteVolunteer(Volunteer volunteer) {
        return false;
    }

    @Override
    public Volunteer getVolunteerById(int id) {
        String sql = "SELECT name FROM volunteers WHERE id = "+id;
        Volunteer volunteer = new Volunteer();
        try (Connection connection = sql2o.open()){
            String name = connection.createQuery(sql).executeScalar(String.class);
            if (name != null){
                volunteer.setIdVolunteer(id);
                volunteer.setName(name);
                return volunteer;
            }
            return null;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public int updateVolunteer(Volunteer volunteer) {
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE volunteers SET name = :name "
                    + "WHERE id = :id")
                    .addParameter("name", volunteer.getName())
                    .addParameter("id", volunteer.getIdVolunteer())
                    .executeUpdate();
            return volunteer.getIdVolunteer();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    @Override
    public List<Volunteer> getAllVolunteers() {
        String sql = "SELECT * FROM volunteers";
        try (Connection connection = sql2o.open()){
            List<Volunteer> volunteers = connection.createQuery(sql).executeAndFetch(Volunteer.class);
            return volunteers;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public int setSkill(int idVolunteer, int idSkill) {
        try (Connection connection = sql2o.open()){
            int newId = (int) connection.createQuery("INSERT INTO volunteer_skill(id_volunteer, id_skill) VALUES (:id_volunteer, :id_skill)",
                    true)
                    .addParameter("id_volunteer", idVolunteer)
                    .addParameter("id_skill", idSkill)
                    .executeUpdate().getKey();
            return newId;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    public List<Integer> getBySkill(int idSkill) {
        String sql = "SELECT id_volunteer FROM volunteer_skill WHERE id_skill = "+idSkill;
        try (Connection connection = sql2o.open()){
            List<Integer> id_volunteers = connection.createQuery(sql).executeScalarList(int.class);
            return id_volunteers;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Volunteer> getVolunteers(List<Integer> ids) {
        List<Volunteer> volunteers = new ArrayList<>();
        for (int id : ids){
            Volunteer volunteer = this.getVolunteerById(id);
            volunteers.add(volunteer);
        }
        return volunteers;
    }

    @Override
    public List<Integer> getByEmergency(int idEmergency) {
        //get tasks
        //get rankings
        //get volunteers
        return null;
    }

    @Override
    public Collection<? extends Integer> getVolunteersByTask(int idTask) {
        String sql = "SELECT id_volunteer FROM rankings WHERE id_task = "+idTask+" and flg_joins = true";
        try (Connection connection = sql2o.open()){
            List<Integer> id_volunteers = connection.createQuery(sql).executeScalarList(int.class);
            return id_volunteers;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}