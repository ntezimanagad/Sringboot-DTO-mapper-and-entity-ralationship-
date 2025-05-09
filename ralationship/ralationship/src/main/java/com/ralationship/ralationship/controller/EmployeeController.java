package com.ralationship.ralationship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ralationship.ralationship.dto.EmployeeDTO;
import com.ralationship.ralationship.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllEmp(){
        return ResponseEntity.ok(employeeService.getAllEmp());
    }
    @PostMapping(value = "/create")
    public ResponseEntity<?> createEmp(@RequestBody EmployeeDTO employeeDTO){
        employeeService.createUser(employeeDTO);
        return ResponseEntity.ok("created");
    }
}
