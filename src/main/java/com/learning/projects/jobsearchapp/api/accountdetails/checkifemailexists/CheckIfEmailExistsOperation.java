package com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists;

import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsResponse;
import com.learning.projects.jobsearchapp.api.base.Operation;

public interface CheckIfEmailExistsOperation extends Operation<CheckIfEmailExistsRequest, CheckIfUsernameExistsResponse> {
    @Override CheckIfUsernameExistsResponse process(CheckIfEmailExistsRequest request);
}
