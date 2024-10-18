package com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists;

import com.learning.projects.jobsearchapp.api.base.OperationResponse;

public record CheckIfEmailExistsResponse(
        boolean emailExists
) implements OperationResponse {
}
