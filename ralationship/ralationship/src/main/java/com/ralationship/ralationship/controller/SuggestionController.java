package com.ralationship.ralationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ralationship.ralationship.dto.SuggestionDTO;
import com.ralationship.ralationship.service.SuggestionService;

@RestController
@RequestMapping("/api/suggestion")
@CrossOrigin("*")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;
    @GetMapping(value = "/getSuggestion")
    public ResponseEntity<List<SuggestionDTO>> getAll(){
        return ResponseEntity.ok(suggestionService.getAllSuggstion());
    }
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody SuggestionDTO suggestionDTO){
        suggestionService.createSuggestion(suggestionDTO);
        return ResponseEntity.ok("created");
    }
}
