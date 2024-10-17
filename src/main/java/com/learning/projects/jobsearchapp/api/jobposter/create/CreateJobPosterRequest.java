package com.learning.projects.jobsearchapp.api.jobposter.create;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.time.LocalDate;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobPosterRequest
        implements OperationRequest {
    private AccountDetails accountDetails;
    private String title;
    private String description;
    private String city;
    private LocalDate validTill;
    private Set<UUID> techStackIds;
}
