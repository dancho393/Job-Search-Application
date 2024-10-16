package com.learning.projects.jobsearchapp.persistence.entity;

import com.learning.projects.jobsearchapp.persistence.entity.constants.AccountDetailsType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDetails  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;
    private String username;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private String city;
    @Enumerated(EnumType.STRING)
    private AccountDetailsType accountType;

    @OneToOne(mappedBy = "accountDetails", cascade = CascadeType.ALL,optional = true)
    private User user;
    @OneToOne(mappedBy = "accountDetails", cascade = CascadeType.ALL,optional = true)
    private Company company;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
