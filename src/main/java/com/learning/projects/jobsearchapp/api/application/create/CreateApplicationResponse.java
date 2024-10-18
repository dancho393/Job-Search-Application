package com.learning.projects.jobsearchapp.api.application.create;

import com.learning.projects.jobsearchapp.api.base.OperationResponse;
import com.learning.projects.jobsearchapp.persistence.entity.JobPoster;
import com.learning.projects.jobsearchapp.persistence.entity.User;
import com.learning.projects.jobsearchapp.persistence.entity.constants.ApplicationStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationResponse implements OperationResponse {
    private UUID id;

    private String applicantName;


    private String jobPosterName;

    private LocalDateTime applicationDateTime;

    private String status;

}
