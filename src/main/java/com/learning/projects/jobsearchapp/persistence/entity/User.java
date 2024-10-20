package com.learning.projects.jobsearchapp.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_details_id", referencedColumnName = "id")
    private AccountDetails accountDetails;

    @OneToMany(mappedBy = "applicant")
    private Set<Application> applications = new HashSet<>();
}
