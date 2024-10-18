package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists.CheckIfEmailExistsOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifemailexists.CheckIfEmailExistsRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.checkifusernameexists.CheckIfUsernameExistsRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserOperation;
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
public class RegisterUserService implements RegisterUserOperation {
    private final AccountDetailsRepository accountDetailsRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterUserAccountDetailsMapper mapper;
    private final CheckIfUsernameExistsOperation checkIfUsernameExistsOperation;
    private final CheckIfEmailExistsOperation checkIfEmailExistsOperation;

    @Override
    public RegisterUserResponse process(RegisterUserRequest request) {

        checkIfUsernameExistsOperation.process(new CheckIfUsernameExistsRequest(request.username()));
        checkIfEmailExistsOperation.process(new CheckIfEmailExistsRequest(request.email()));

        AccountDetails accountDetails = mapper.toAccountDetails(request);
        accountDetails.setPassword(getEncryptedPassword(request.password()));

        accountDetailsRepository.save(accountDetails);

        Set<Application> applications = new HashSet<>();
        User user = mapper.toUser(accountDetails);

        userRepository.save(user);

        return mapper.toRegisterUserResponse(accountDetails);
    }

    private String getEncryptedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
