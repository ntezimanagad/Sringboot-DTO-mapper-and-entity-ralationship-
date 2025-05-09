package com.ralationship.ralationship.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ralationship.ralationship.dto.EmployeeDTO;
import com.ralationship.ralationship.dto.SuggestionDTO;
import com.ralationship.ralationship.model.Employee;
import com.ralationship.ralationship.model.Suggestion;

public class EmployeeMapper {
    public static EmployeeDTO toDto(Employee employee){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setPassword(employee.getPassword());

        List<SuggestionDTO> suggestionDTOs = employee.getSuggestion() != null 
            ? employee.getSuggestion().stream()
                .map(SuggestionMapper::toDto)
                .collect(Collectors.toList())
            : new ArrayList<>();
        dto.setSuggestions(suggestionDTOs);
        return dto;
    }
    public static Employee toEntity(EmployeeDTO employeeDto){
        Employee dto = new Employee();
        dto.setId(employeeDto.getId());
        dto.setName(employeeDto.getName());
        dto.setEmail(employeeDto.getEmail());
        dto.setPassword(employeeDto.getPassword());

        List<SuggestionDTO> suggestionDTOs = employeeDto.getSuggestions() != null 
            ? employeeDto.getSuggestions()
            : new ArrayList<>();
        List<Suggestion> suggestions = suggestionDTOs.stream()
            .map(EmployeeMapper::toMapSuggestion)
            .collect(Collectors.toList());
        dto.setSuggestion(suggestions);
        return dto;
    }

    public static Suggestion toMapSuggestion(SuggestionDTO suggestionDTO){
        Suggestion suggestion = new Suggestion();
        suggestion.setId(suggestionDTO.getId());
        suggestion.setTitle(suggestionDTO.getTitle());
        suggestion.setDescription(suggestionDTO.getDescription());
        suggestion.setStatus(suggestionDTO.getStatus());
        return suggestion;
    }
}
