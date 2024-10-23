package com.learning.projects.jobsearchapp.api.accountdetails.registercompany;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;
import jakarta.validation.constraints.NotEmpty;

public record RegisterCompanyRequest (
      @NotEmpty(message = "Username is required") String username,
      @NotEmpty(message = "Password is required")  String password,
      @NotEmpty(message = "Your Full Name Is Required")   String name,
      @NotEmpty(message = "Your Email Is Required")  String email,
      @NotEmpty(message = "Your Address Is Required")  String address,
      @NotEmpty(message = "Your Phone Number Is Required")  String phoneNumber,
      @NotEmpty(message = "Your City Is Required")  String city,
      @NotEmpty(message = "Enter Your Employee Count")  int employeeCount
)implements OperationRequest {
}
