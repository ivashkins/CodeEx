package com.example.codeexample.service;

import com.example.codeexample.entity.User;
import com.example.codeexample.mapper.UserMapper;
import com.example.codeexample.dto.UserDto;
import com.example.codeexample.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;

    public UserServiceImpl(UserMapper mapper, UserRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public ResponseEntity<User> createNewUser(UserDto userDto) {
        User user = mapper.toUser(userDto);
        repository.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<List<User>> findByParameters(UserDto userDto) {
        User user = mapper.toUser(userDto);
        Example<User> example = Example.of(user);
        return ResponseEntity.of(Optional.of(repository.findAll(example)));
    }

    @Override
    public ResponseEntity<User> getById(Long id) {
       return ResponseEntity.of(repository.findById(id));
    }
}
