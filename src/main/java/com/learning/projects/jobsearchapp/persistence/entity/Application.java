        package com.learning.projects.jobsearchapp.persistence.entity;

        import com.learning.projects.jobsearchapp.persistence.entity.constants.ApplicationStatus;
        import jakarta.persistence.*;
        import lombok.*;
        import org.hibernate.annotations.CreationTimestamp;

        import java.time.LocalDateTime;
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


            private LocalDateTime applicationDateTime;

            @Enumerated(EnumType.STRING)
            private ApplicationStatus status;
        }
