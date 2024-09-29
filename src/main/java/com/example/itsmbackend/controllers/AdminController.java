package com.example.itsmbackend.controllers;

import com.example.itsmbackend.payloads.UserDTO;
import com.example.itsmbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import com.example.itsmbackend.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The AdminController class is a REST controller that provides endpoints for retrieving all admins and all users.
 * The AdminController class is annotated with @RestController to enable Spring to automatically
 * generate REST-ful endpoints for the class.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;

    /**
     * Constructor for AdminController
     * @param userService UserService object
     */
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get all admins
     * @return list of admins
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all-admins")
    public ResponseEntity<?> getAllAdmins() {
        try{
            List<UserDTO> admins = userService.getAllAdmins();
            // Convert the response into a DTO
            return ResponseEntity.ok(admins);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Get all users
     * @return list of users
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        try{
            List<UserDTO> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
