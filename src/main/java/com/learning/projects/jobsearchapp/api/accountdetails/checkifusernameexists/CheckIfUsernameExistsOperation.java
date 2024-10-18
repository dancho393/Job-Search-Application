package com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists;

import com.learning.projects.jobsearchapp.api.base.Operation;

public interface CheckIfUsernameExistsOperation
extends Operation<CheckIfUsernameExistsRequest,CheckIfUsernameExistsResponse> {
    @Override
    CheckIfUsernameExistsResponse process(CheckIfUsernameExistsRequest request);
}
