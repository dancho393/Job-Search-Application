package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserResponse;
import com.learning.projects.jobsearchapp.api.mapper.accountdetails.registeruser.RegisterUserAccountDetailsMapper;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import com.learning.projects.jobsearchapp.persistence.entity.Application;
import com.learning.projects.jobsearchapp.persistence.entity.User;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;
import com.learning.projects.jobsearchapp.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegisterUserOperation implements com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserOperation {
    private final AccountDetailsRepository accountDetailsRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterUserAccountDetailsMapper mapper;

    @Override
    public RegisterUserResponse process(RegisterUserRequest request) {
        AccountDetails accountDetails = mapper.toAccountDetails(request);

        accountDetails.setPassword(getEncryptedPassword(request.password()));

        accountDetailsRepository.save(accountDetails);

        Set<Application> applications = new HashSet<>();
        User user = (User) mapper.toUser(accountDetails);

        userRepository.save(user);

        return mapper.toRegisterUserResponse(accountDetails);
    }

    private String getEncryptedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
