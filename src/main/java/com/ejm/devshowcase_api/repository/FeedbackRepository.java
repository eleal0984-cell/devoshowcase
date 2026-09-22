package com.ejm.devshowcase_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ejm.devshowcase_api.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
} 
