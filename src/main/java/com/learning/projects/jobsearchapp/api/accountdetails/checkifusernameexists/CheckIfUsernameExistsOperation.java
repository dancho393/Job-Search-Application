package com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists;

import com.learning.projects.jobsearchapp.api.base.Operation;
import com.learning.projects.jobsearchapp.rest.exception.EntityAlreadyExistsException;


public interface CheckIfUsernameExistsOperation
extends Operation<CheckIfUsernameExistsRequest,CheckIfUsernameExistsResponse> {
    @Override
    CheckIfUsernameExistsResponse process(CheckIfUsernameExistsRequest request) throws EntityAlreadyExistsException;
}
