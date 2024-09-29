package com.example.itsmbackend.controllers;


import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.payloads.LoginRequest;
import com.example.itsmbackend.payloads.UserDTO;
import com.example.itsmbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * The AuthController class is a REST controller that handles requests related to authentication.
 * It provides endpoints for user login, user registration, and user logout.
 * The AuthController class is annotated with @RestController to enable Spring to automatically
 * generate REST-ful endpoints for the class.
 */
@RestController
@RequestMapping("/public/api/auth")
public class AuthController {

    private final UserService userService;


    private final AuthenticationManager authenticationManager;

    /**
     * Constructor for AuthController
     * @param userService UserService object
     * @param authenticationManager AuthenticationManager object
     */
    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Login a user with the given email and password
     * @param loginRequest LoginRequest object
     * @return UserDTO object
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(), loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            User user = userService.findUserByEmail(userDetails.getUsername());
            UserDTO responseUser = new UserDTO(
                    user.getUserId(),
                    user.getFullName(),
                    user.getEmail(),
                    user.getRole().name()
            );

            return ResponseEntity.ok(responseUser);

        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        }
    }

    /**
     * Register a new user with the given details
     * @param user User object
     * @return User object
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
       try{
           Optional<User> userInDb = Optional.ofNullable(userService.findUserByEmail(user.getEmail()));
           if(userInDb.isPresent()){
               return new ResponseEntity<>("Email is already present in the database", HttpStatus.OK);
           }
           userService.createUser(user);
              return new ResponseEntity<>(user, HttpStatus.CREATED);

       }catch(Exception e){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
    }

    /**
     * Logout the current user
     * @return ResponseEntity
     */
    @GetMapping("/logout")
    public ResponseEntity<?> logout(){
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>("Logout successful", HttpStatus.OK);
    }
}
