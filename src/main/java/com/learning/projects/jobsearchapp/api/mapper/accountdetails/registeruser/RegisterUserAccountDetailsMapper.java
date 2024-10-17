package com.learning.projects.jobsearchapp.api.mapper.accountdetails.registeruser;

import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserRequest;
import com.learning.projects.jobsearchapp.api.accountdetails.registeruser.RegisterUserResponse;
import com.learning.projects.jobsearchapp.persistence.entity.AccountDetails;
import com.learning.projects.jobsearchapp.persistence.entity.User; // Import your User entity
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RegisterUserAccountDetailsMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "username", source = "username"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "phoneNumber", source = "phoneNumber"),
            @Mapping(target = "city", source = "city"),
            @Mapping(target = "message", constant = "User registered successfully")
    })
    RegisterUserResponse toRegisterUserResponse(AccountDetails accountDetails);

    @Mappings({
            @Mapping(target = "accountDetails", source = "accountDetails"),
            @Mapping(target = "applications", source = "user.applications")
    })
    User toUser(AccountDetails accountDetails);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", source = "request.username")
    @Mapping(target = "name", source = "request.name")
    @Mapping(target = "address", source = "request.address")
    @Mapping(target = "phoneNumber", source = "request.phoneNumber")
    @Mapping(target = "city", source = "request.city")
    @Mapping(target = "accountType", constant = "USER")
    @Mapping(target = "password", ignore = true)
    AccountDetails toAccountDetails(RegisterUserRequest request);
}
