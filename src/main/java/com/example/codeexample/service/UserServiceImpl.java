package com.example.codeexample.service;

import com.example.codeexample.dto.UserDto;
import com.example.codeexample.entity.User;
import com.example.codeexample.mapper.UserMapper;
import com.example.codeexample.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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

    public Optional<User> createNewUser(UserDto userDto) {
        User user = mapper.toUser(userDto);
        repository.save(user);
        return Optional.of(user);
    }

    @Override
    public Optional<List<User>> findByParameters(UserDto userDto) {
        User user = mapper.toUser(userDto);
        Example<User> example = Example.of(user);
        return Optional.of(repository.findAll(example));
    }

    @Override
    public Optional<User> getById(Long id) {
       return repository.findById(id);
    }
}
