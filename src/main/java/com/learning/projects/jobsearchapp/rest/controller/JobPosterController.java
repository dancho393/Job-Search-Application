package com.learning.projects.jobsearchapp.rest.controller;

import com.learning.projects.jobsearchapp.api.jobposter.create.CreateJobPosterOperation;
import com.learning.projects.jobsearchapp.api.jobposter.create.CreateJobPosterRequest;
import com.learning.projects.jobsearchapp.api.jobposter.create.CreateJobPosterResponse;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jobposter")
@RequiredArgsConstructor
public class JobPosterController {
    private final CreateJobPosterOperation createJobPosterOperation;

    @PreAuthorize("hasAuthority('COMPANY')")
    @PostMapping
    public ResponseEntity<CreateJobPosterResponse> createJobPoster(
            @RequestBody CreateJobPosterRequest request,
            @AuthenticationPrincipal AccountDetails accountDetails
    ) {
        request.setAccountDetails(accountDetails);
        return ResponseEntity.status(201).body(createJobPosterOperation.process(request));
    }
}
