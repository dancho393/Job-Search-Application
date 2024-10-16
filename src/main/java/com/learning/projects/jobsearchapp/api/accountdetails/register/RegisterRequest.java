package com.learning.projects.jobsearchapp.api.accountdetails.register;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;

public record RegisterRequest(
         String username,
         String password,
         String name,
         String address,
         String phoneNumber,
         String city,
         String accountType
)implements OperationRequest {
}
