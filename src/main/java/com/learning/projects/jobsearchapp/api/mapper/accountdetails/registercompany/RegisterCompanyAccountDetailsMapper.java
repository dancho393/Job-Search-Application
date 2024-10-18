package com.learning.projects.jobsearchapp.api.mapper.accountdetails.registercompany;

import com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.registercompany.RegisterCompanyResponse;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import com.learning.projects.jobsearchapp.persistence.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RegisterCompanyAccountDetailsMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "username", source = "username"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "phoneNumber", source = "phoneNumber"),
            @Mapping(target = "city", source = "city"),
            @Mapping(target = "employeeCount", source = "company.employeeCount"),
            @Mapping(target = "rating", source = "company.rating"),
            @Mapping(target = "message", constant = "Company registered successfully")
    })
    RegisterCompanyResponse toRegisterCompanyResponse(AccountDetails accountDetails);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "accountDetails", source = "accountDetails") ,
            @Mapping(target = "employeeCount", source = "employeeCount"),
            @Mapping(target = "rating", constant = "0.0f")
    })
    Company toCompany(int employeeCount, AccountDetails accountDetails);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", source = "request.username")
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "email" , source = "request.email")
    @Mapping(target = "address", source = "request.address")
    @Mapping(target = "phoneNumber", source = "request.phoneNumber")
    @Mapping(target = "city", source = "request.city")
    @Mapping(target = "accountType", constant = "COMPANY")
    @Mapping(target = "password", ignore = true)
    AccountDetails toAccountDetails(RegisterCompanyRequest request);
}
