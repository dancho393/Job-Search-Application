package com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;

public record CheckIfEmailExistsRequest(
        String email
) implements OperationRequest {
}
