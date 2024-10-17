package com.learning.projects.jobsearchapp.api.jobposter.create;

import com.learning.projects.jobsearchapp.api.base.Operation;

public interface CreateJobPosterOperation
        extends Operation<CreateJobPosterRequest, CreateJobPosterResponse> {
    @Override
    CreateJobPosterResponse process(CreateJobPosterRequest request);
}
