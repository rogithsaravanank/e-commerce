package com.spring.e_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.e_commerce.entity.User;
import com.spring.e_commerce.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody User user){
        try {
            userService.createUser(user);
            return ResponseEntity.status(201).body("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating user");
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUser(){
        return userService.getUser();
    }
    
    // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<List<User>> getUser() {
    //     List<User> users = userService.getUser();
    //     if (users.isEmpty()) {
    //         return ResponseEntity.noContent().build(); // 204 No Content if no users are found
    //     }
    //     return ResponseEntity.ok(users); // 200 OK with the list of users
    // }
    
}
