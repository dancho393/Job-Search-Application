package com.learning.projects.jobsearchapp.persistence.repository;

import com.learning.projects.jobsearchapp.persistence.entity.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TechStackRepository extends JpaRepository<TechStack, UUID> {
}
