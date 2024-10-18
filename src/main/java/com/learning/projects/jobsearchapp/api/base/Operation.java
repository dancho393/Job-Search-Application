package com.learning.projects.jobsearchapp.api.base;


import com.learning.projects.jobsearchapp.rest.exception.EntityAlreadyExistsException;

public interface Operation <I extends OperationRequest,O extends OperationResponse>{
    O process(I request) throws EntityAlreadyExistsException;
}
