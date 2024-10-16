package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyResponse;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import com.learning.projects.jobsearchapp.persistence.entity.Company;
import com.learning.projects.jobsearchapp.persistence.entity.constants.AccountDetailsType;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;
import com.learning.projects.jobsearchapp.persistence.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterCompanyOperation implements com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyOperation {
    private final AccountDetailsRepository accountDetailsRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterCompanyResponse process(RegisterCompanyRequest request) {
        AccountDetails accountDetails = AccountDetails.builder()
                .name(request.name())
                .password(passwordEncoder.encode(request.password()))
                .city(request.city())
                .address(request.address())
                .phoneNumber(request.phoneNumber())
                .username(request.username())
                .accountType(AccountDetailsType.COMPANY) // Setting accountType to Company
                .build();

        accountDetailsRepository.save(accountDetails);

        Company company = Company.builder()
                .id(UUID.randomUUID())
                .accountDetails(accountDetails)
                .employeeCount(request.employeeCount())
                .rating(0.0f)
                .build();

        companyRepository.save(company);
        return new RegisterCompanyResponse("Company registered successfully with rating 0");
    }
}
