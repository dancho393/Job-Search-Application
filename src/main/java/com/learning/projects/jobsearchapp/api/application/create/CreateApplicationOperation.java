package com.learning.projects.jobsearchapp.api.application.create;

import com.learning.projects.jobsearchapp.api.base.Operation;

public interface CreateApplicationOperation
        extends Operation<CreateApplicationRequest, CreateApplicationResponse> {
    @Override
    CreateApplicationResponse process(CreateApplicationRequest request);
}
