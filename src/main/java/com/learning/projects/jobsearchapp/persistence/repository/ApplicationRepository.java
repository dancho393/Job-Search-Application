package com.learning.projects.jobsearchapp.persistence.repository;

import com.learning.projects.jobsearchapp.persistence.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<Application, UUID> {
}
