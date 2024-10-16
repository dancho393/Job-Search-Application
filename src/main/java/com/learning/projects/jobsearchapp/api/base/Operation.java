package com.learning.projects.jobsearchapp.api.base;

public interface Operation <I extends OperationRequest,O extends OperationResponse>{
    O process(I request);
}
