package com.learning.projects.jobsearchapp.api.accountdetails.registeruser;

import com.learning.projects.jobsearchapp.api.base.OperationResponse;

import java.util.UUID;

public record RegisterUserResponse(
        UUID id,
        String username,
        String name,
        String email,
        String address,
        String phoneNumber,
        String city,
        String message
) implements OperationResponse {

}
