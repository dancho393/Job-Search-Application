package com.learning.projects.jobsearchapp.api.mapper.application;

import com.learning.projects.jobsearchapp.api.application.create.CreateApplicationRequest;
import com.learning.projects.jobsearchapp.api.application.create.CreateApplicationResponse;
import com.learning.projects.jobsearchapp.persistence.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateApplicationMapper {

    @Mapping(target = "status", constant = "APPLIED")
    @Mapping(target = "applicationDateTime", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(source = "request.accountDetails.user", target = "applicant")
    Application toApplication(CreateApplicationRequest request);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "applicant.accountDetails.name", target = "applicantName")
    @Mapping(source = "jobPoster.title", target = "jobPosterName")
    @Mapping(source = "applicationDateTime", target = "applicationDateTime")
    @Mapping(source = "status", target = "status")
    CreateApplicationResponse toResponse(Application application);
}
