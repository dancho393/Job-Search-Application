package com.learning.projects.jobsearchapp.api.application.create;

import com.learning.projects.jobsearchapp.api.base.OperationRequest;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationRequest implements OperationRequest {
    private AccountDetails accountDetails;
    private String jobId;
}
