package com.learning.projects.jobsearchapp.api.accountdetails.login;

import com.learning.projects.jobsearchapp.api.base.Operation;

public interface LoginOperation extends Operation<LoginRequest,LoginResponse> {
    @Override
    LoginResponse process(LoginRequest request);
}
