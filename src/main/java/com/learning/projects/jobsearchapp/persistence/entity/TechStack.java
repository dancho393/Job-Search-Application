package com.learning.projects.jobsearchapp.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.UUID;

@Entity
@Table(name = "tech_stacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    private String name;
    private String description;
    private String image;
    @ManyToMany(mappedBy = "techStacks")
    private HashSet<JobPoster> jobPosters = new HashSet<>();
}
