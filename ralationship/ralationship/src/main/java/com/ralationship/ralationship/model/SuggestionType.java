package com.ralationship.ralationship.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SuggestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "suggestionType", cascade = CascadeType.ALL)
    private List<Suggestion> suggestion;
    public SuggestionType() {
    }
    public SuggestionType(String name, List<Suggestion> suggestion) {
        this.name = name;
        this.suggestion = suggestion;
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
    public List<Suggestion> getSuggestion() {
        return suggestion;
    }
    public void setSuggestion(List<Suggestion> suggestion) {
        this.suggestion = suggestion;
    }
    
    
}
