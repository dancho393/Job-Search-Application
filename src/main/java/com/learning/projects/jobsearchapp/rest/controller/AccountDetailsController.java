package com.learning.projects.jobsearchapp.rest.controller;

import com.learning.projects.jobsearchapp.api.accountdetails.login.LoginOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.login.LoginRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.login.LoginResponse;
import com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyResponse;
import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserResponse;

import com.learning.projects.jobsearchapp.rest.exception.EntityAlreadyExistsException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AccountDetailsController {
    private final RegisterUserOperation registerUserOperation;
    private final LoginOperation loginOperation;
    private final RegisterCompanyOperation registerCompanyOperation;
    @PostMapping("/registeruser")
    public ResponseEntity<RegisterUserResponse> registerUser(
            @RequestBody  RegisterUserRequest registerRequest)  {
        return ResponseEntity.status(201).body(registerUserOperation.process(registerRequest));
    }

    @PostMapping("/registercompany")
    public ResponseEntity<RegisterCompanyResponse> registerCompany(
            @RequestBody RegisterCompanyRequest registerRequest) {
        return ResponseEntity.status(201).body(registerCompanyOperation.process(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest) {
            return ResponseEntity.ok(loginOperation.process(loginRequest));
    }
}
