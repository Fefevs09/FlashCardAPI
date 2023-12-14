package com.felipeZe.FlashCardAPI.controllers;

import com.felipeZe.FlashCardAPI.services.UserService;
import com.felipeZe.FlashCardAPI.entities.user.Users;
import com.felipeZe.FlashCardAPI.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUser() {
        List<Users> users = userService.listUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
