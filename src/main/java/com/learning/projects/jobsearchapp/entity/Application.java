        package com.learning.projects.jobsearchapp.entity;

        import com.learning.projects.jobsearchapp.entity.constants.ApplicationStatus;
        import jakarta.persistence.*;
        import lombok.*;

        import java.util.UUID;

        @Entity
        @Table(name = "applications")
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        public class Application {
            @Id
            @GeneratedValue(strategy = GenerationType.UUID)
            private UUID id;
            @ManyToOne
            @JoinColumn(name = "user_id")
            private User applicant;

            @ManyToOne
            @JoinColumn(name = "jobposter_id")
            private JobPoster jobPoster;

            @Enumerated(EnumType.STRING)
            private ApplicationStatus status;
        }
