package com.ralationship.ralationship.dto;

import java.util.List;


public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<SuggestionDTO> suggestions;
    
    
    public EmployeeDTO(String name, String email, String password, List<SuggestionDTO> suggestions) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.suggestions = suggestions;
    }
    public EmployeeDTO() {
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<SuggestionDTO> getSuggestions() {
        return suggestions;
    }
    public void setSuggestions(List<SuggestionDTO> suggestions) {
        this.suggestions = suggestions;
    }
    
    
}
