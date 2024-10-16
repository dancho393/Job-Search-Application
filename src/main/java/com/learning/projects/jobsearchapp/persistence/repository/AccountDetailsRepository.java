package com.learning.projects.jobsearchapp.persistence.repository;

import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, UUID> {
    Optional<AccountDetails> findByUsername(String username);
}
