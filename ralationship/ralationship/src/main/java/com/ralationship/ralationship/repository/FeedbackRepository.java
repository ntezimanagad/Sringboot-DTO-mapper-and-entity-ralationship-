package com.ralationship.ralationship.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ralationship.ralationship.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
    Optional<Feedback> findByComments(String comments);
}
