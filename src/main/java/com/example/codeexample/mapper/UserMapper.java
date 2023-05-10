package com.example.codeexample.mapper;

import com.example.codeexample.dto.UserDto;
import com.example.codeexample.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDto dto);
}
