package com.learning.projects.jobsearchapp.persistence.repository;

import com.learning.projects.jobsearchapp.persistence.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
