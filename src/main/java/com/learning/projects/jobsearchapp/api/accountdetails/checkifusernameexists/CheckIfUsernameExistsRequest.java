package com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;

public record CheckIfUsernameExistsRequest(
        String username
) implements OperationRequest {
}
