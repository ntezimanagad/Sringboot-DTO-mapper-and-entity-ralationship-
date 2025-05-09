package com.ralationship.ralationship.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ralationship.ralationship.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Optional<Employee> findByEmail(String email);
    List<Employee> findAll();
}
