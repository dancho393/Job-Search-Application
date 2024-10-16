package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.register.RegisterOperation;
import com.learning.projects.jobsearchapp.api.accountdetails.register.RegisterRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.register.RegisterResponse;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import com.learning.projects.jobsearchapp.persistence.entity.Company;
import com.learning.projects.jobsearchapp.persistence.entity.User;
import com.learning.projects.jobsearchapp.persistence.entity.constants.AccountDetailsType;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;
import com.learning.projects.jobsearchapp.persistence.repository.CompanyRepository;
import com.learning.projects.jobsearchapp.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class RegisterOperationIMPL implements RegisterOperation {
    private final AccountDetailsRepository accountDetailsRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public RegisterResponse process(RegisterRequest request) {
        AccountDetails accountDetails =
                AccountDetails.builder()
                        .name(request.name())
                        .password(passwordEncoder.encode(request.password()))
                        .city(request.city())
                        .address(request.address())
                        .phoneNumber(request.phoneNumber())
                        .username(request.username())
                        .accountType(AccountDetailsType.valueOf(request.accountType()))
                        .build();
                       accountDetails.setUser(User.builder()
                                        .accountDetails(accountDetails)
                                       .applications(new HashSet<>())
                               .build());
        accountDetailsRepository.save(accountDetails);

        return new RegisterResponse("Created");
    }
}
