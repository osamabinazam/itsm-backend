package com.example.itsmbackend.controllers;

import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/all-users")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
