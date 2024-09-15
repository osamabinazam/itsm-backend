package com.example.itsmbackend.controllers;

import com.example.itsmbackend.entity.Assignment;
import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.payloads.SiteDTO;
import com.example.itsmbackend.payloads.UserDTO;
import com.example.itsmbackend.repository.AssignmentRepository;
import com.example.itsmbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * Create a new user
     * @param user
     * @return
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
     * Get all users
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    ResponseEntity<?> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findByUserId(userId));
    }

    /**
     * Get all sites of the user
     * @param userId
     * @return
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
     * Get all sites of the Authenticated User
     * @return
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
     * Get the Supervisor or supervisors of the user
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
     * Get the Supervisor or supervisors of the user
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
     * Get the supervisor of a user
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
