package com.ralationship.ralationship.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ralationship.ralationship.dto.FeedbackDTO;
import com.ralationship.ralationship.dto.SuggestionDTO;
import com.ralationship.ralationship.model.Feedback;
import com.ralationship.ralationship.model.Suggestion;

public class SuggestionMapper {
    public static SuggestionDTO toDto(Suggestion suggestion){
        SuggestionDTO dto = new SuggestionDTO();
        dto.setId(suggestion.getId());
        dto.setTitle(suggestion.getTitle());
        dto.setDescription(suggestion.getDescription());
        dto.setStatus(suggestion.getStatus());
        dto.setEmployee_id(suggestion.getEmployee() != null ? suggestion.getEmployee().getId() : null);
        dto.setSuggestionType_id(suggestion.getSuggestionType() != null ? suggestion.getSuggestionType().getId() : null);

        List<FeedbackDTO> feedbackDTOs = suggestion.getFeedbacks() != null
            ? suggestion.getFeedbacks().stream()
                .map(FeedbackMapper::toDto)
                .collect(Collectors.toList())
            : new ArrayList<>();
        dto.setFeedbacks(feedbackDTOs);
        return dto;
    }

    public static Suggestion toEntity(SuggestionDTO suggestionDto){
        Suggestion dto = new Suggestion();
        dto.setId(suggestionDto.getId());
        dto.setTitle(suggestionDto.getTitle());
        dto.setDescription(suggestionDto.getDescription());
        dto.setStatus(suggestionDto.getStatus());

        List<FeedbackDTO> feedbackDTOs = suggestionDto.getFeedbacks() != null
            ? suggestionDto.getFeedbacks()
            : new ArrayList<>();
        
        List<Feedback> feedbacks = feedbackDTOs.stream()
                .map(SuggestionMapper::toMapFeedback)
                .collect(Collectors.toList());
        dto.setFeedbacks(feedbacks);
        return dto;
    }

    public static Feedback toMapFeedback(FeedbackDTO feedbackDTO){
        Feedback feedback = new Feedback();
        feedback.setId(feedbackDTO.getId());
        feedback.setComments(feedbackDTO.getComments());
        feedback.setDecision(feedbackDTO.getDecision());
        return feedback;
    }
}
