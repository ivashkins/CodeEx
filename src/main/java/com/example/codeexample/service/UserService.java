package com.example.codeexample.service;

import com.example.codeexample.dto.UserDto;
import com.example.codeexample.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Optional<User> createNewUser(UserDto userDto);

    Optional<List<User>> findByParameters(UserDto params);

    Optional<User> getById(Long id);
}
