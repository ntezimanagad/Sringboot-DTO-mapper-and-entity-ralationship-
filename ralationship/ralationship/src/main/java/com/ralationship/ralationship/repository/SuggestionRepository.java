package com.ralationship.ralationship.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ralationship.ralationship.model.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long>{
    Optional<Suggestion> findByTitle(String title);
}
