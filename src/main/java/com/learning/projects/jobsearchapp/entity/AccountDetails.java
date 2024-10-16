package com.learning.projects.jobsearchapp.entity;

import com.learning.projects.jobsearchapp.entity.constants.AccountDetailsType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Entity
@Table(name = "account_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDetails  {
    @Id
    private UUID id;
    private String username;
    private String password;
    private String name;
    private String address;
    private String phoneNumber;
    private String city;
    @Enumerated(EnumType.STRING)
    private AccountDetailsType accountType;
    private String accountId;



}
