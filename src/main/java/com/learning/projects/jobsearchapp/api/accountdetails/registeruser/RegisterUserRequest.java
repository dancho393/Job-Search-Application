package com.learning.projects.jobsearchapp.api.accountdetails.registeruser;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(
        @NotEmpty(message = "Username is required") String username,
        @NotEmpty(message = "Password is required")  String password,
        @NotEmpty(message = "Your Full Name Is Required")   String name,
        @NotEmpty(message = "Your Email Is Required")  String email,
        @NotEmpty(message = "Your Address Is Required")  String address,
        @NotEmpty(message = "Your Phone Number Is Required")  String phoneNumber,
        @NotEmpty(message = "Your City Is Required")  String city
)implements OperationRequest {
}
