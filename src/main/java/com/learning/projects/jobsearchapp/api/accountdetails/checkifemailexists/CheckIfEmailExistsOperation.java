package com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists;

import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsResponse;
import com.learning.projects.jobsearchapp.api.base.Operation;
import com.learning.projects.jobsearchapp.rest.exception.EntityAllreadyExists;

public interface CheckIfEmailExistsOperation extends Operation<CheckIfEmailExistsRequest, CheckIfUsernameExistsResponse> {
    @Override CheckIfUsernameExistsResponse process(CheckIfEmailExistsRequest request) throws EntityAllreadyExists;
}
