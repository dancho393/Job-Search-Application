package com.learning.projects.jobsearchapp.persistence.repository;

import com.learning.projects.jobsearchapp.persistence.entity.JobPoster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobPosterRepository extends JpaRepository<JobPoster, UUID> {
}
