package com.learning.projects.jobsearchapp.api.accountdetails.registercompany;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;

public record RegisterCompanyRequest (
        String username,
        String password,
        String name,
        String email,
        String address,
        String phoneNumber,
        String city,
        int employeeCount
)implements OperationRequest {
}
