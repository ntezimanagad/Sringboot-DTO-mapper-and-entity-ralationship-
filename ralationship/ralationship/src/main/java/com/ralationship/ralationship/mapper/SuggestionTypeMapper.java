package com.ralationship.ralationship.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ralationship.ralationship.dto.SuggestionDTO;
import com.ralationship.ralationship.dto.SuggestionTypeDTO;
import com.ralationship.ralationship.model.Suggestion;
import com.ralationship.ralationship.model.SuggestionType;

public class SuggestionTypeMapper {
    public static SuggestionTypeDTO toDto(SuggestionType suggestionType){
        SuggestionTypeDTO dto = new SuggestionTypeDTO();
        dto.setId(suggestionType.getId());
        dto.setName(suggestionType.getName());
        
        List<SuggestionDTO> suggestionDTOs = suggestionType.getSuggestion() != null 
            ? suggestionType.getSuggestion().stream()
                .map(SuggestionMapper::toDto)
                .collect(Collectors.toList())
            : new ArrayList<>();
        dto.setSuggestions(suggestionDTOs);
        return dto;
    }
    public static SuggestionType toEntity(SuggestionTypeDTO suggestionTypeDTO){
        SuggestionType dto = new SuggestionType();
        dto.setId(suggestionTypeDTO.getId());
        dto.setName(suggestionTypeDTO.getName());
        
        List<SuggestionDTO> suggestionDTOs = suggestionTypeDTO.getSuggestions() != null 
            ? suggestionTypeDTO.getSuggestions()  
            : new ArrayList<>();
        List<Suggestion> suggestions = suggestionDTOs.stream()
            .map(SuggestionTypeMapper::toMapSuggestion)
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
