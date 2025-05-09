package com.ralationship.ralationship.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ralationship.ralationship.dto.EmployeeDTO;
import com.ralationship.ralationship.mapper.EmployeeMapper;
import com.ralationship.ralationship.model.Employee;
import com.ralationship.ralationship.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<EmployeeDTO> getAllEmp(){
        return employeeRepository.findAll()
            .stream()
            .map(EmployeeMapper::toDto)
            .collect(Collectors.toList());
    }
    public EmployeeDTO createUser(EmployeeDTO employeeDTO){
        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDTO.getEmail());
        if (optionalEmployee.isPresent()) {
            throw new RuntimeException("user already exist");
        }
        Employee employee = EmployeeMapper.toEntity(employeeDTO);
        Employee emp = employeeRepository.save(employee);
        return EmployeeMapper.toDto(emp);
    }
}
