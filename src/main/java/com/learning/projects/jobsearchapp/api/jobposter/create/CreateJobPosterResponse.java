package com.learning.projects.jobsearchapp.api.jobposter.create;

import com.learning.projects.jobsearchapp.api.base.OperationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobPosterResponse implements OperationResponse {
    private UUID id;
    private String title;
    private String description;
    private String city;
    private LocalDate postedDate;
    private LocalDate validTill;
    private Set<String> techStacks;
    private String companyName;
}
