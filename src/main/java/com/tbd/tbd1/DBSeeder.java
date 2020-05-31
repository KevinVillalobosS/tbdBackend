package com.tbd.tbd1;

import com.tbd.tbd1.repository.DatabaseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;


@Component
public class DBSeeder implements CommandLineRunner {

    @Autowired
    private Sql2o sql2o;

    private List<String> querys = new ArrayList<String>(){{
        add("CREATE TABLE IF NOT EXISTS volunteers (" +
                "id_volunteer serial," +
                "name varchar(32) NOT NULL," +
                "PRIMARY KEY (id_volunteer))");
        add("CREATE TABLE IF NOT EXISTS emergencies (" +
                "id_emergency serial," +
                "emergencyName varchar(32) NOT NULL," +
                "description varchar(100) NOT NULL," +
                "startDate varchar(20) NOT NULL," +
                "endDate varchar(20) NOT NULL," +
                "idInstitution integer NOT NULL," +
                "PRIMARY KEY (id_emergency))");
        add("CREATE TABLE IF NOT EXISTS skills (" +
                "id_skill serial," +
                "description varchar(100) NOT NULL," +
                "PRIMARY KEY (id_skill))");

    }};


    @Override
    public void run(String... args) throws Exception {

        try (Connection connection = sql2o.open()){
            for (String query : querys){
                connection.createQuery(query).executeUpdate();
            }

            System.out.println("ok");
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }




    }
}
