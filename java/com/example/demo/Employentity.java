package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "Employees")
public class Employentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // works with SQLite INTEGER PRIMARY KEY
    private Long id;

    @Column(nullable = false)
    private String name;

    private String title;

    private Double salary;

    public Employentity() {}

    public Employentity(String name, String title, Double salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }


}
