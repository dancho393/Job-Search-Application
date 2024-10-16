package com.learning.projects.jobsearchapp.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "job_posters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPoster {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    private String title;
    private String description;
    private String city;
    private LocalDate postedDate;
    private LocalDate validTill;
    @ManyToMany
    @JoinTable(
            name = "jobposter_techstack", // Join table name
            joinColumns = @JoinColumn(name = "jobposter_id"), // JobPoster side join column
            inverseJoinColumns = @JoinColumn(name = "techstack_id") // TechStack side join column
    )
    private Set<TechStack> techStacks;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "jobPoster")
    private Set<Application> applications= new HashSet<Application>();
}
