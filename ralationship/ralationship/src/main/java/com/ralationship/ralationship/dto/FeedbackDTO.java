package com.ralationship.ralationship.dto;

public class FeedbackDTO {
    private Long id;
    private String comments;
    private String decision;
    private Long suggestion_id;

    

    public FeedbackDTO(String comments, String decision, Long suggestion_id) {
        this.comments = comments;
        this.decision = decision;
        this.suggestion_id = suggestion_id;
    }

    public FeedbackDTO() {
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Long getSuggestion_id() {
        return suggestion_id;
    }

    public void setSuggestion_id(Long suggestion_id) {
        this.suggestion_id = suggestion_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    
}
