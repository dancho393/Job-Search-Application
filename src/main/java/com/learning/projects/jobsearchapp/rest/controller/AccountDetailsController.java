package com.learning.projects.jobsearchapp.rest.controller;

import com.learning.projects.jobsearchapp.api.accountdetails.login.LoginOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.login.LoginRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.login.LoginResponse;
import com.learning.projects.jobsearchapp.api.accountdetails.register.RegisterOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.register.RegisterRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.register.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AccountDetailsController {
    private final RegisterOperation registerOperation;
    private final LoginOperation loginOperation;
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
           @RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.status(201).body(registerOperation.process(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest) {
            return ResponseEntity.ok(loginOperation.process(loginRequest));
    }
}
