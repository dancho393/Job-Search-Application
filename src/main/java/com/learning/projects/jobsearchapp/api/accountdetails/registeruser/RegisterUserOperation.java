package com.learning.projects.jobsearchapp.api.accountdetails.registeruser;

import com.learning.projects.jobsearchapp.api.base.Operation;
import com.learning.projects.jobsearchapp.rest.exception.EntityAlreadyExistsException;

public interface RegisterUserOperation
        extends Operation<RegisterUserRequest,RegisterUserResponse> {
    @Override
    RegisterUserResponse process(RegisterUserRequest request) throws EntityAlreadyExistsException;
}
