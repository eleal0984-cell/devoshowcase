package com.ejm.devshowcase_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ejm.devshowcase_api.model.Technology;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}