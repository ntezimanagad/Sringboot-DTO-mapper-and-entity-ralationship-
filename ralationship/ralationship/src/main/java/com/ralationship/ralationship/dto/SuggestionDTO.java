package com.ralationship.ralationship.dto;

import java.util.*;

public class SuggestionDTO {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Long suggestionType_id;
    private Long employee_id;
    private List<FeedbackDTO> feedbacks;


    public SuggestionDTO() {
    }

    

    public SuggestionDTO(String title, String description, String status, Long suggestionType_id, Long employee_id,
            List<FeedbackDTO> feedbacks) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.suggestionType_id = suggestionType_id;
        this.employee_id = employee_id;
        this.feedbacks = feedbacks;
    }



    public Long getSuggestionType_id() {
        return suggestionType_id;
    }

    public void setSuggestionType_id(Long suggestionType_id) {
        this.suggestionType_id = suggestionType_id;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public List<FeedbackDTO> getFeedbacks() {
        return feedbacks;
    }



    public void setFeedbacks(List<FeedbackDTO> feedbacks) {
        this.feedbacks = feedbacks;
    }

    
    
}
