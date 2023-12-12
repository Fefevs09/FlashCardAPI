package com.felipeZe.FlashCardAPI.api.Controller;

import com.felipeZe.FlashCardAPI.Service.UserService;
import com.felipeZe.FlashCardAPI.api.Model.Users;
import com.felipeZe.FlashCardAPI.dtos.UserDTO;
import org.apache.catalina.User;
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

    @GetMapping("/user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) throws Exception {
        Users user = userService.findUserById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping("/user")
    public ResponseEntity<Users> createUser(@RequestBody UserDTO createUser) {
        Users user = userService.createUser(createUser);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody UserDTO updateUser) throws Exception {
        Users user = this.userService.updateUser(id,updateUser);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Users> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
