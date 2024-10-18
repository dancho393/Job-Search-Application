package com.learning.projects.jobsearchapp.api.accountdetails.registercompany;

import com.learning.projects.jobsearchapp.api.base.Operation;
import com.learning.projects.jobsearchapp.rest.exception.EntityAlreadyExistsException;

public interface RegisterCompanyOperation extends Operation<RegisterCompanyRequest, RegisterCompanyResponse> {
    RegisterCompanyResponse process(RegisterCompanyRequest request) throws EntityAlreadyExistsException;
}
