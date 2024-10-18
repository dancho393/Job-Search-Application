package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsResponse;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;
import com.learning.projects.jobsearchapp.rest.exception.EntityAllreadyExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckIfUsernameExistsService implements CheckIfUsernameExistsOperation {

    private final AccountDetailsRepository accountDetailsRepository;

    @Override
    public CheckIfUsernameExistsResponse process(CheckIfUsernameExistsRequest request) throws EntityAllreadyExists {
        String username = request.username();

        if (accountDetailsRepository.existsByUsername(username)) {
            throw new EntityAllreadyExists("Username '" + username + "' already exists.");
        }

        return new CheckIfUsernameExistsResponse(false);
    }
}
