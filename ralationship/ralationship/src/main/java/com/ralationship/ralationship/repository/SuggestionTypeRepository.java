package com.ralationship.ralationship.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ralationship.ralationship.model.SuggestionType;

public interface SuggestionTypeRepository extends JpaRepository<SuggestionType, Long>{
    Optional<SuggestionType> findByName(String name);
}
