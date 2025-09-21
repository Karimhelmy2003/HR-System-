package com.example.demo;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
//http://localhost:8888/api/usersword
//http://localhost:8888/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
public class Filecontroller {

    private Emolyerepositry repo;

    public Filecontroller(Emolyerepositry repo) {
        this.repo = repo;
    }

    // Dbconnection obj=new Dbconnection();
   // public Filecontroller() {
        //obj.cretaetable();

//    }

    ArrayList<Emolyee> employe = new ArrayList<>();

    Dbconnection db = new Dbconnection();



    @GetMapping("/getallemploye")
    public List<Employentity> getallemp() {

        return repo.findAll();

    }

    @GetMapping("/getemployebyid{id}")
    public Employentity one(@PathVariable Long id) {
        return repo.findById(id).get();
    }

    @PostMapping("/addemployee")
    public Employentity addempolyee(@RequestBody Employentity employee) {

        return repo.save(employee);
    }

    @PutMapping("/updateemploye/{id}")
    public Employentity updatedemploye(@PathVariable long id, @RequestBody Employentity employee) {
        //obj.updateemployee(id,employee);
//        return repo.findById(id)
//                .map(existing -> {
//                    existing.setName(employee.getName());
//                    existing.setTitle(employee.getTitle());
//                    existing.setSalary(employee.getSalary());
//                    return repo.save(existing);
//                })
//                .orElse(null); // لو مش لاقي بيرجع
        employee.setId(id);
        return repo.save(employee);

    }


    @DeleteMapping("/Deleteemp/{id}")
    public void deleteemployee(@PathVariable long id) {
        //obj.deleteemployee(id);
        //if (repo.existsById(id)) {
        //  repo.deleteById(id); // DELETE
        //  return ResponseEntity.noContent().build(); // 204 No Content
        //  } else {
        //  return ResponseEntity.notFound().build(); // 404 if not found
        //  }
        repo.deleteById(id);
    }
}











