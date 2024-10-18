package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists.CheckIfEmailExistsOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists.CheckIfEmailExistsRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsResponse;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;
import com.learning.projects.jobsearchapp.rest.exception.EntityAllreadyExists;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckIfEmailExistsService implements CheckIfEmailExistsOperation {

    private final AccountDetailsRepository accountDetailsRepository;

    @Override
    public CheckIfUsernameExistsResponse process(CheckIfEmailExistsRequest request) throws EntityAllreadyExists {
        String email = request.email();

        if (accountDetailsRepository.existsByEmail(email)) {
            throw new EntityAllreadyExists("Email '" + email + "' already exists.");
        }

        return new CheckIfUsernameExistsResponse(false);
    }
}
