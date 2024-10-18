package com.learning.projects.jobsearchapp.api.accountdetails.registercompany;

import com.learning.projects.jobsearchapp.api.base.OperationResponse;

import java.util.UUID;

public record RegisterCompanyResponse (
         UUID id,
         String username,
         String name,
         String email,
         String address,
         String phoneNumber,
         String city,
         int employeeCount,
         Float rating,
        String message
)implements OperationResponse
{

}