package com.ralationship.ralationship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ralationship.ralationship.dto.SuggestionTypeDTO;
import com.ralationship.ralationship.service.SuggestionTypeService;

@RestController
@RequestMapping(value = "/api/suggest")
@CrossOrigin("*")
public class SuggestionTypeController {
    @Autowired
    private SuggestionTypeService suggestionTypeService;
    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllSugge(){
        return ResponseEntity.ok(suggestionTypeService.getAllSuggestionType());
    }
    @PostMapping(value = "/create")
    public ResponseEntity<?> createSugge(@RequestBody SuggestionTypeDTO suggestionTypeDTO){
        suggestionTypeService.createSuggeType(suggestionTypeDTO);
        return ResponseEntity.ok("created");
    }
}
