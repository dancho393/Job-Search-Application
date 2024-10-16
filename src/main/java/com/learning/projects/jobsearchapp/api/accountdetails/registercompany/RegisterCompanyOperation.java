package com.learning.projects.jobsearchapp.api.accountdetails.registercompany;

import com.learning.projects.jobsearchapp.api.base.Operation;

public interface RegisterCompanyOperation extends Operation<RegisterCompanyRequest, RegisterCompanyResponse> {
    RegisterCompanyResponse process(RegisterCompanyRequest request);
}
