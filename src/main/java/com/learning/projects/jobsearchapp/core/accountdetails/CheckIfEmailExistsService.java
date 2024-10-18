package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists.CheckIfEmailExistsOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists.CheckIfEmailExistsRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsResponse;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckIfEmailExistsService implements CheckIfEmailExistsOperation {

    private final AccountDetailsRepository accountDetailsRepository;

    @Override
    public CheckIfUsernameExistsResponse process(CheckIfEmailExistsRequest request) {
        String email = request.email();

        if (accountDetailsRepository.existsByEmail(email)) {
            throw new RuntimeException("Email '" + email + "' already exists.");
        }

        return new CheckIfUsernameExistsResponse(false);
    }
}
