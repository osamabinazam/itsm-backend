package com.example.itsmbackend.controllers;

import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.payloads.SiteDTO;
import com.example.itsmbackend.payloads.UserDTO;
import com.example.itsmbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The UserController class is a REST controller that handles requests related to users.
 * It provides endpoints for creating users, getting user details, and getting user sites.
 * It also provides endpoints for getting supervisors and supervisor details.
 * The UserController class is annotated with @RestController to enable Spring to automatically
 * generate REST-ful endpoints for the class.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    /**
     * Constructor for UserController
     * @param userService UserService object
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user with the given details
     * @param user User object
     * @return User object
     */
    @PostMapping
    User createUser(@RequestBody User user){
        try{
            return userService.createUser(user);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * Get a user by user ID
     * @param userId User ID
     * @return User object
     */
    @GetMapping("/{userId}")
    ResponseEntity<?> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findByUserId(userId));
    }

    /**
     * Get All Site for assigned to given user
     * @param userId User ID
     * @return List of sites
     */
    @PreAuthorize("hasAnyRole('CO','RM', 'TGL', 'PM')")
    @GetMapping("/{userId}/sites")
    ResponseEntity<?> getAllUserSite(@PathVariable Long userId){
       try{
              List<SiteDTO> sites = userService.getAllUserSite(userId);
              return ResponseEntity.ok(sites);
         } catch (Exception e){
              return ResponseEntity.badRequest().body("User not found");
       }
    }

    /**
     * Get all sites for the current user
     * @return List of sites
     */
    @PreAuthorize("hasAnyRole('CO','RM', 'TGL', 'PM')")
    @GetMapping("/sites")
    ResponseEntity<?> getAllUserSite(){
       try{
           User user = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
              List<SiteDTO> sites = userService.getAllUserSite(user.getUserId());
              return ResponseEntity.ok(sites);
         } catch (Exception e){
              return ResponseEntity.badRequest().body("User not found");
       }
    }


    /**
     * Get all supervisors for the given user
     * @param userId User ID
     * @return List of supervisors
     */
    @PreAuthorize("hasAnyRole('CO','RM', 'TGL')")
    @GetMapping("/{userId}/supervisors")
    ResponseEntity<?> getSupervisors(@PathVariable Long userId){
        try{
            List<UserDTO> supervisors = userService.getAllSupervisors(userId);
            return ResponseEntity.ok(supervisors);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("User not found");
        }
    }


    /**
     * Get all supervisors for the current user
     * @return List of supervisors
     */
    @PreAuthorize("hasAnyRole('CO','RM', 'TGL')")
    @GetMapping("/supervisors")
    ResponseEntity<?> getSupervisors(){
        try{
            List<UserDTO> supervisors = userService.getAllSupervisors(
                    userService.findUserByEmail(
                            SecurityContextHolder.getContext().getAuthentication().getName()
                    ).getUserId()
            );
            return ResponseEntity.ok(supervisors);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("User not found");
        }
    }

    /**
     * Get the supervisor for the given user
     * @param userId User ID
     * @return Supervisor object
     */
    @PreAuthorize("hasAnyRole('CO','RM', 'TGL')")
    @GetMapping("/{userId}/supervisor")
    ResponseEntity<?> getSupervisor(@PathVariable Long userId){
        try{
            UserDTO supervisor = userService.getSupervisor(userId);
            return ResponseEntity.ok(supervisor);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("User not found");
        }
    }

}
