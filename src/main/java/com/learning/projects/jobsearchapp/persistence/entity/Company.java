package com.learning.projects.jobsearchapp.persistence.entity;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_details_id", referencedColumnName = "id")
    private AccountDetails accountDetails;
    private int employeeCount;
    private Float rating;

    @OneToMany(mappedBy = "company")
    private Set<JobPoster> jobPosters;


}
