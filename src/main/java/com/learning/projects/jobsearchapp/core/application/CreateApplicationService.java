package com.learning.projects.jobsearchapp.core.application;

import com.learning.projects.jobsearchapp.api.application.create.CreateApplicationOperation;
import com.learning.projects.jobsearchapp.api.application.create.CreateApplicationRequest;
import com.learning.projects.jobsearchapp.api.application.create.CreateApplicationResponse;
import com.learning.projects.jobsearchapp.api.mapper.application.CreateApplicationMapper;
import com.learning.projects.jobsearchapp.persistence.entity.Application;
import com.learning.projects.jobsearchapp.persistence.entity.JobPoster;
import com.learning.projects.jobsearchapp.persistence.entity.constants.ApplicationStatus;
import com.learning.projects.jobsearchapp.persistence.repository.ApplicationRepository;
import com.learning.projects.jobsearchapp.persistence.repository.JobPosterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateApplicationService implements CreateApplicationOperation {
    private final ApplicationRepository applicationRepository;
    private final JobPosterRepository jobPosterRepository;
    private final CreateApplicationMapper mapper;
    @Override
    public CreateApplicationResponse process(CreateApplicationRequest request) {

        JobPoster jobPoster = jobPosterRepository
                .getReferenceById(UUID.fromString(request.getJobId()));

        Application application = mapper.toApplication(request);
        application.setJobPoster(jobPoster);
        applicationRepository.save(application);

        return mapper.toResponse(application);

    }
}
