package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists.CheckIfEmailExistsOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists.CheckIfEmailExistsRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists.CheckIfEmailExistsResponse;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsResponse;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;


import com.learning.projects.jobsearchapp.rest.exception.EntityAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckIfEmailExistsService implements CheckIfEmailExistsOperation {

    private final AccountDetailsRepository accountDetailsRepository;

    @Override
    public CheckIfEmailExistsResponse process(CheckIfEmailExistsRequest request) throws EntityAlreadyExistsException {
        String email = request.email();

        if (accountDetailsRepository.existsByEmail(email)) {
            throw new EntityAlreadyExistsException("Email '" + email + "' already exists.");
        }

        return new CheckIfEmailExistsResponse(false);
    }
}
