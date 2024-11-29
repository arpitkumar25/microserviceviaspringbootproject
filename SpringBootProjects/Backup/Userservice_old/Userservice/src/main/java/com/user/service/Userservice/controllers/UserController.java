package com.microservice.user.service.Userservice.controllers;

import com.microservice.user.service.Userservice.entities.User;
import com.microservice.user.service.Userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/userService")
public class UserController {

    @Autowired
    private UserService userService;

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1= userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //single user get
    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
        User user1= userService.getUser(userId);
        return ResponseEntity.ok(user1);
    }

    //all user get
    //single user get
    @GetMapping
    public ResponseEntity<List<User>> getSingleUser()
    {
        List<User> users= userService.getAllUser();
        return ResponseEntity.ok(users);
    }
}
