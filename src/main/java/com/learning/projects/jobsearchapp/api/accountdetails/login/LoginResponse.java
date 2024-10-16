package com.learning.projects.jobsearchapp.api.accountdetails.login;

import com.learning.projects.jobsearchapp.api.base.OperationResponse;

public record LoginResponse(
        String jwtToken
)implements OperationResponse {
}
