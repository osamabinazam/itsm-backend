package com.example.itsmbackend.controllers;

import com.example.itsmbackend.entity.Request;
import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.RequestStatus;
import com.example.itsmbackend.entity.enums.RequestType;
import com.example.itsmbackend.payloads.RequestDTO;
import com.example.itsmbackend.payloads.UserDTO;
import com.example.itsmbackend.service.RequestService;
import com.example.itsmbackend.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/request")
public class RequestController {
    @Autowired
    private RequestService requestService;
    @Autowired
    private UserService userService;


    @PreAuthorize("hasAnyRole('TGL', 'PM', 'RM')")
    @GetMapping("/all-requests")
    ResponseEntity<?> getAllRequestOfUser() {
        try {
            Optional<User> user = Optional.ofNullable(userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
            if (user.isPresent()) {
                List<RequestDTO> requests = requestService.getAllRequestOfUser(user.get().getUserId(), String.valueOf(user.get().getRole()));
                return new ResponseEntity<>(requests,HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }


        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * Create a request
     *
     */

    @PreAuthorize("hasRole('CO')")
    @PostMapping
    ResponseEntity<?> createRequest(@RequestBody RequestDTO requestDTO) {
        try {
            RequestDTO newRequest = requestService.createRequest(requestDTO);
            return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     */
    @PreAuthorize("hasAnyRole('TGL', 'PM','RM')")
    @PutMapping("/{id}")
    ResponseEntity<?> updateRequest(@RequestBody RequestDTO requestDTO, @PathVariable Long id){
        try{
            if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
                RequestDTO updatedRequest = requestService.updateRequest(requestDTO,id );
                // Convert it into DTO
                return new ResponseEntity<>(updatedRequest,HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Not Authenticated",HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}