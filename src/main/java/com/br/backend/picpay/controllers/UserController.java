package com.br.backend.picpay.controllers;

import com.br.backend.picpay.annotations.Info;
import com.br.backend.picpay.domain.user.User;
import com.br.backend.picpay.dtos.UserDto;
import com.br.backend.picpay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Info(author = "Jean Paul", date = "25/08/2023")
@RestController("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(UserDto userDto) {
        User newUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
