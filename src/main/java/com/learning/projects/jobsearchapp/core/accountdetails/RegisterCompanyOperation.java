package com.learning.projects.jobsearchapp.core.accountdetails;

import com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyResponse;

import com.learning.projects.jobsearchapp.api.mapper.accountdetails.registercompany.RegisterCompanyAccountDetailsMapper;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import com.learning.projects.jobsearchapp.persistence.entity.Company;
import com.learning.projects.jobsearchapp.persistence.repository.AccountDetailsRepository;
import com.learning.projects.jobsearchapp.persistence.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCompanyOperation implements com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyOperation {
    private final AccountDetailsRepository accountDetailsRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterCompanyAccountDetailsMapper mapper;

    @Override
    public RegisterCompanyResponse process(RegisterCompanyRequest request) {
        AccountDetails accountDetails = mapper.toAccountDetails(request);

        accountDetails.setPassword(getEncryptedPassword(request.password()));

        accountDetailsRepository.save(accountDetails);

        Company company = mapper.toCompany(request.employeeCount(),accountDetails);

        accountDetails.setCompany(company);
        companyRepository.save(company);



        return mapper.toRegisterCompanyResponse(accountDetails);
    }
    private String getEncryptedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
