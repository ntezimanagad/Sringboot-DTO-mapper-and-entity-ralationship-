package com.ralationship.ralationship.dto;

import java.util.List;

public class SuggestionTypeDTO {
    private Long id;
    private String name;
    private List<SuggestionDTO> suggestions;
    
    public SuggestionTypeDTO(String name, List<SuggestionDTO> suggestions) {
        this.name = name;
        this.suggestions = suggestions;
    }
    public SuggestionTypeDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<SuggestionDTO> getSuggestions() {
        return suggestions;
    }
    public void setSuggestions(List<SuggestionDTO> suggestions) {
        this.suggestions = suggestions;
    }
    
    
    
}
