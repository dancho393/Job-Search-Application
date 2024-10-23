package com.learning.projects.jobsearchapp.core.jobposter;

import com.learning.projects.jobsearchapp.api.jobposter.create.CreateJobPosterOperation;
import com.learning.projects.jobsearchapp.api.jobposter.create.CreateJobPosterRequest;
import com.learning.projects.jobsearchapp.api.jobposter.create.CreateJobPosterResponse;
import com.learning.projects.jobsearchapp.api.mapper.jobposter.CreateJobPosterMapper;
import com.learning.projects.jobsearchapp.persistence.entity.JobPoster;
import com.learning.projects.jobsearchapp.persistence.entity.TechStack;
import com.learning.projects.jobsearchapp.persistence.repository.JobPosterRepository;
import com.learning.projects.jobsearchapp.persistence.repository.TechStackRepository;
import com.learning.projects.jobsearchapp.rest.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateJobPosterService implements CreateJobPosterOperation {
    private final JobPosterRepository jobPosterRepository;
    private final TechStackRepository techStackRepository;
    private final CreateJobPosterMapper mapper;
    @Override
    @Transactional
    public CreateJobPosterResponse process(CreateJobPosterRequest request) {

        JobPoster jobPoster = mapper.mapToJobPoster(request);
        Set<TechStack> techStacks =
                new HashSet<>(techStackRepository.findAllById(request.getTechStackIds()));


        jobPoster.setApplications(new HashSet<>());
        jobPoster.setPostedDate(LocalDate.now());
        jobPoster.setTechStacks(techStacks);


        jobPosterRepository.save(jobPoster);
        CreateJobPosterResponse response = mapper.mapToCreateJobPosterResponse(jobPoster);
        response.setTechStacks(getTechStackNames(techStacks));

        return response;
    }
    private Set<String> getTechStackNames(Set<TechStack> techStacks){
        return techStacks.stream()
                .map(TechStack::getName)
                .collect(Collectors.toSet());
    }
}
