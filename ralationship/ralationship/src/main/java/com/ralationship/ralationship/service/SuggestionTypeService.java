package com.ralationship.ralationship.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ralationship.ralationship.dto.SuggestionTypeDTO;
import com.ralationship.ralationship.mapper.SuggestionTypeMapper;
import com.ralationship.ralationship.model.SuggestionType;
import com.ralationship.ralationship.repository.SuggestionTypeRepository;
@Service
public class SuggestionTypeService {
    @Autowired
    private SuggestionTypeRepository suggestionTypeRepository;
    public List<SuggestionTypeDTO> getAllSuggestionType(){
        return suggestionTypeRepository.findAll()
            .stream()
            .map(SuggestionTypeMapper::toDto)
            .collect(Collectors.toList());
    }
    public SuggestionTypeDTO createSuggeType(SuggestionTypeDTO suggestionTypeDTO){
        Optional<SuggestionType> optionalSuggetion = suggestionTypeRepository.findByName(suggestionTypeDTO.getName());
        if (optionalSuggetion.isPresent()) {
            throw new RuntimeException("Suggestion type already exist");
        }
        SuggestionType suggestion = SuggestionTypeMapper.toEntity(suggestionTypeDTO);
        SuggestionType type = suggestionTypeRepository.save(suggestion);
        return SuggestionTypeMapper.toDto(type);
    }
}
