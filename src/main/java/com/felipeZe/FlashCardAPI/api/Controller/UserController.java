package com.felipeZe.FlashCardAPI.api.Controller;

import com.felipeZe.FlashCardAPI.Service.UserService;
import com.felipeZe.FlashCardAPI.api.Model.User;
import com.felipeZe.FlashCardAPI.api.Requests.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users =  userService.listUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            return new  ResponseEntity<>(user.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody CreateUser createUser) {
        User user = userService.createUser(createUser.createUser());

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody CreateUser createUser) {
        Optional<User> optionalUser = userService.getUser(id);
        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User user = optionalUser.get();

        user.setNome(createUser.nome());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@RequestBody Long id) {
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
