package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserResponse;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import com.learning.projects.jobsearchapp.persistence.entity.User;
import com.learning.projects.jobsearchapp.persistence.entity.constants.AccountDetailsType;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;
import com.learning.projects.jobsearchapp.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class RegistraterUseroperation implements RegisterUserOperation {
    private final AccountDetailsRepository accountDetailsRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterUserResponse process(RegisterUserRequest request) {
        AccountDetails accountDetails = AccountDetails.builder()
                .name(request.name())
                .password(passwordEncoder.encode(request.password()))
                .city(request.city())
                .address(request.address())
                .phoneNumber(request.phoneNumber())
                .username(request.username())
                .accountType(AccountDetailsType.USER)
                .build();

        User user = User.builder()
                .accountDetails(accountDetails)
                .applications(new HashSet<>())
                .build();

        accountDetails.setUser(user);
        accountDetailsRepository.save(accountDetails);

        userRepository.save(user);

        return new RegisterUserResponse("Created User");
    }
}
