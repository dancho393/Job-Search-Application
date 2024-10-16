package com.learning.projects.jobsearchapp.api.accountdetails.login;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;

public record LoginRequest(
        String username,
        String password
)implements OperationRequest {
}
