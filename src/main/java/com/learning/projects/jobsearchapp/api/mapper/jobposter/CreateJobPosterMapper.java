package com.learning.projects.jobsearchapp.api.mapper.jobposter;

import com.learning.projects.jobsearchapp.api.jobposter.create.CreateJobPosterRequest;
import com.learning.projects.jobsearchapp.api.jobposter.create.CreateJobPosterResponse;
import com.learning.projects.jobsearchapp.persistence.entity.JobPoster;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CreateJobPosterMapper {

    @Mappings({
    @Mapping(target = "applications", ignore = true),
    @Mapping(target = "postedDate", ignore = true),
    @Mapping(target = "techStacks", ignore = true),
    @Mapping(target = "company",source ="accountDetails.company" )
            })
    JobPoster mapToJobPoster(CreateJobPosterRequest request);

    @Mappings({
            @Mapping(source = "company.accountDetails.name", target = "companyName"),
            @Mapping(target = "techStacks", ignore = true)
    })
    CreateJobPosterResponse mapToCreateJobPosterResponse(JobPoster jobPoster);
}
