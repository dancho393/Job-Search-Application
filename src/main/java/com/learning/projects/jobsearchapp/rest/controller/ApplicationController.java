package com.learning.projects.jobsearchapp.rest.controller;

import com.learning.projects.jobsearchapp.api.application.create.CreateApplicationOperation;
import com.learning.projects.jobsearchapp.api.application.create.CreateApplicationRequest;
import com.learning.projects.jobsearchapp.api.application.create.CreateApplicationResponse;
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
@RequiredArgsConstructor
@RequestMapping("/api/v1/application")
public class ApplicationController {
    private final CreateApplicationOperation createApplicationOperation;
    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<CreateApplicationResponse> createApplication(
            @RequestBody CreateApplicationRequest request,
            @AuthenticationPrincipal AccountDetails accountDetails) {

        request.setAccountDetails(accountDetails);
        return ResponseEntity.status(201).body(createApplicationOperation.process(request));

    }
}
