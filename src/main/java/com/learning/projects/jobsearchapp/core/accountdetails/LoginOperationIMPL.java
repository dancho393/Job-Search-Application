package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.login.LoginOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.login.LoginRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.login.LoginResponse;
import com.learning.projects.jobsearchapp.core.security.JwtService;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;
import com.learning.projects.jobsearchapp.rest.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginOperationIMPL implements LoginOperation {
    private final AccountDetailsRepository accountDetailsRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public LoginResponse process(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        var user = accountDetailsRepository.findByUsername(request.username())
                .orElseThrow(()->new EntityNotFoundException("User Not Found"));
        var jwtToken =jwtService.generateToken(user);
        return new LoginResponse(jwtToken);
    }
}
