package com.kayky.domain.user;

import com.kayky.domain.user.response.UserGetResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserGetResponse toResponse(User patient);
}