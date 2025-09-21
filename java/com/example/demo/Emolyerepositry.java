package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public interface Emolyerepositry extends JpaRepository<Employentity, Long> {
    // examples of derived queries

    List<Employentity> findByTitle(String title);
    List<Employentity> findBySalaryGreaterThan(Double salary);


}
