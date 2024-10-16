package com.learning.projects.jobsearchapp.api.accountdetails.registeruser;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;

public record RegisterUserRequest(
         String username,
         String password,
         String name,
         String address,
         String phoneNumber,
         String city
)implements OperationRequest {
}
