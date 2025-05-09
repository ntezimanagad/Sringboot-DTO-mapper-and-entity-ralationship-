package com.ralationship.ralationship.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ralationship.ralationship.dto.SuggestionDTO;
import com.ralationship.ralationship.mapper.SuggestionMapper;
import com.ralationship.ralationship.model.Employee;
import com.ralationship.ralationship.model.Suggestion;
import com.ralationship.ralationship.model.SuggestionType;
import com.ralationship.ralationship.repository.EmployeeRepository;
import com.ralationship.ralationship.repository.SuggestionRepository;
import com.ralationship.ralationship.repository.SuggestionTypeRepository;

@Service
public class SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SuggestionTypeRepository suggestionTypeRepository;
     public List<SuggestionDTO> getAllSuggstion(){
        return suggestionRepository.findAll()
            .stream()
            .map(SuggestionMapper::toDto)
            .collect(Collectors.toList());
     }

     public SuggestionDTO createSuggestion(SuggestionDTO suggestionDTO){
        Suggestion suggestion = SuggestionMapper.toEntity(suggestionDTO);
        if (suggestionDTO.getEmployee_id() != null) {
            Employee employee = employeeRepository.findById(suggestionDTO.getEmployee_id())
                .orElseThrow(()-> new RuntimeException("employee not found"));
            suggestion.setEmployee(employee);
        }
        if (suggestionDTO.getSuggestionType_id() != null) {
            SuggestionType suggestionType = suggestionTypeRepository.findById(suggestionDTO.getSuggestionType_id())
                .orElseThrow(()-> new RuntimeException("Notfound"));
            suggestion.setSuggestionType(suggestionType);
        }
        Suggestion sugge = suggestionRepository.save(suggestion);
        return SuggestionMapper.toDto(sugge);
     }
}
