package com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists;

import com.learning.projects.jobsearchapp.api.base.OperationResponse;

public record CheckIfUsernameExistsResponse(
        boolean usernameExists
) implements OperationResponse {
}
