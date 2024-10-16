package com.learning.projects.jobsearchapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    @OneToOne
    private AccountDetails accountDetails;
    private int employeeCount;
    private Float rating;

    @OneToMany(mappedBy = "company")
    private Set<JobPoster> jobPosters;


}
