package com.example.codeexample.service;

import com.example.codeexample.dto.UserDto;
import com.example.codeexample.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public ResponseEntity<User> createNewUser(UserDto userDto);

    ResponseEntity<List<User>> findByParameters(UserDto params);

    ResponseEntity<User> getById(Long id);
}
