package com.example.codeexample.controller;

import com.example.codeexample.dto.UserDto;
import com.example.codeexample.entity.User;
import com.example.codeexample.service.UserService;
import com.example.codeexample.validated.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/search/{id}")
    public ResponseEntity<User> searchById(@PathVariable("id") Long id) {
        return ResponseEntity.of(userService.getById(id));
    }

    @GetMapping("/search/user")
    public ResponseEntity<List<User>> getUsersByParameters(@Validated(FindByParameters.class) UserDto userDto){
        return ResponseEntity.of(userService.findByParameters(userDto));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/newUser",
            headers = "x-Source=MAIL")
    public ResponseEntity<User> createNewUserMail(@Validated(MailValidated.class) @RequestBody UserDto userDto) {
        return ResponseEntity.of(userService.createNewUser(userDto));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/newUser",
            headers = "x-Source=MOBILE")
    public ResponseEntity<User> createNewUserMobile(@Validated(MobileValidated.class) @RequestBody UserDto userDto) {
        return ResponseEntity.of(userService.createNewUser(userDto));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/newUser",
            headers = "x-Source=BANK")
    public ResponseEntity<User> createNewUserBank(@Validated(BankValidated.class) @RequestBody UserDto userDto) {
        return ResponseEntity.of(userService.createNewUser(userDto));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/newUser",
            headers = "x-Source=Gosuslugi")
    public ResponseEntity<User> createNewUserGosusligu(@Validated(GosuslugiValidated.class) @RequestBody UserDto userDto) {
        return ResponseEntity.of(userService.createNewUser(userDto));
    }
}

