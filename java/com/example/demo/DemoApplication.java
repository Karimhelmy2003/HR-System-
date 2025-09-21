package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final Dbconnection db;

    public DemoApplication() {
        this.db = new Dbconnection();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (db.retermployes().isEmpty()) {
            db.resetEmployeesTable();
            System.out.println("Employees table reset at first startup.");
        }
    }
}

