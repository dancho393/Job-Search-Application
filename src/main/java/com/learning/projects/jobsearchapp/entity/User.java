package com.learning.projects.jobsearchapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private UUID id;
    @OneToOne
    private AccountDetails accountDetails;
    @OneToMany(mappedBy = "applicant")
    private Set<Application> applications;
}
