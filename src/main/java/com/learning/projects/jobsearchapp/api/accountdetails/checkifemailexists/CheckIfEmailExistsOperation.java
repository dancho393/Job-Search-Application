package com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists;

import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsResponse;
import com.learning.projects.jobsearchapp.api.base.Operation;
import com.learning.projects.jobsearchapp.rest.exception.EntityAlreadyExistsException;


public interface CheckIfEmailExistsOperation extends Operation<CheckIfEmailExistsRequest, CheckIfEmailExistsResponse> {
    @Override CheckIfEmailExistsResponse process(CheckIfEmailExistsRequest request) throws EntityAlreadyExistsException;
}
