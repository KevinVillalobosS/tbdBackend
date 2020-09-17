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
        add("CREATE TABLE IF NOT EXISTS public.volunteers (" +
                "id serial," +
                "name varchar(32) NOT NULL," +
                "location geometry(point)," +
                "PRIMARY KEY (id))"
        );
        add("CREATE TABLE IF NOT EXISTS public.emergencies (" +
                "id serial," +
                "name varchar(32) NOT NULL," +
                "description varchar(100) NOT NULL," +
                "startDate varchar(20) NOT NULL," +
                "endDate varchar(20) NOT NULL," +
                "location geometry(point)," +
                "idInstitution integer NOT NULL," +
                "PRIMARY KEY (id))");
        add("CREATE TABLE IF NOT EXISTS public.skills (" +
                "id serial," +
                "description varchar(100) NOT NULL," +
                "PRIMARY KEY (id))");
        add("CREATE TABLE IF NOT EXISTS public.tasks (" +
                "id serial," +
                "name varchar(32) NOT NULL," +
                "description varchar(100) NOT NULL," +
                "req_volunteers integer NOT NULL," +
                "enrolled_volunteers integer NOT NULL," +
                "id_emergency integer NOT NULL," +
                "startDate varchar(20) NOT NULL," +
                "endDate varchar(20) NOT NULL," +
                "id_status integer NOT NULL," +
                "PRIMARY KEY (id))");
        add("CREATE TABLE IF NOT EXISTS public.institution (" +
                "id serial," +
                "name varchar(32) NOT NULL," +
                "PRIMARY KEY (id))");
        add("CREATE TABLE IF NOT EXISTS public.rankings (" +
                "id serial," +
                "id_volunteer integer NOT NULL," +
                "id_task integer NOT NULL," +
                "score integer NOT NULL," +
                "flg_invited BOOLEAN NOT NULL," +
                "flg_joins BOOLEAN NOT NULL," +
                "PRIMARY KEY (id))");
        add("CREATE TABLE IF NOT EXISTS public.emerg_skill (" +
                "id serial," +
                "id_emergency integer NOT NULL," +
                "id_skill integer NOT NULL," +
                "PRIMARY KEY (id))");
        add("CREATE TABLE IF NOT EXISTS public.volunteer_skill (" +
                "id serial," +
                "id_volunteer integer NOT NULL," +
                "id_skill integer NOT NULL," +
                "PRIMARY KEY (id))");
        add("CREATE TABLE IF NOT EXISTS public.task_skill (" +
                "id serial," +
                "id_task integer NOT NULL," +
                "id_skill integer NOT NULL," +
                "PRIMARY KEY (id))");
        add("CREATE TABLE IF NOT EXISTS public.task_status (" +
                "id serial," +
                "description varchar(32) NOT NULL," +
                "PRIMARY KEY (id))");
        add("CREATE OR REPLACE PROCEDURE close_full_tasks()\n" +
                "LANGUAGE SQL\n" +
                "AS $$\n" +
                "UPDATE tasks SET id_status = 2 WHERE req_volunteers <= enrolled_volunteers;\n" +
                "$$");
        add("INSERT INTO volunteers (name, location) VALUES ('kevin', ST_GeomFromText('POINT(-33.447487 -70.673676)', 4326))");
        add("INSERT INTO volunteers (name, location) VALUES ('leuco', ST_GeomFromText('POINT(-33.54684 -70.67534)', 4326))");
        add("INSERT INTO volunteers (name, location) VALUES ('edson', ST_GeomFromText('POINT(-33.67534 -70.54684)', 4326))");
        add("INSERT INTO volunteers (name, location) VALUES ('enzo', ST_GeomFromText('POINT(-33.65564 -70.65564)', 4326))");
        add("INSERT INTO volunteers (name, location) VALUES ('gore', ST_GeomFromText('POINT(-33.65894 -70.65489)', 4326))");
        add("INSERT INTO volunteers (name, location) VALUES ('estefan', ST_GeomFromText('POINT(-33.65489 -70.65894)', 4326))");
        add("INSERT INTO volunteers (name, location) VALUES ('steffan', ST_GeomFromText('POINT(-33.65579 -70.68945)', 4326))");
        add("INSERT INTO volunteers (name, location) VALUES ('brandon', ST_GeomFromText('POINT(-33.68945 -70.65579)', 4326))");
        add("INSERT INTO volunteers (name, location) VALUES ('cami', ST_GeomFromText('POINT(-33.65579 -70.489865)', 4326))");

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
