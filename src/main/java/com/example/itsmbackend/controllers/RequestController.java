package com.example.itsmbackend.controllers;

import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.payloads.RequestDTO;
import com.example.itsmbackend.service.RequestService;
import com.example.itsmbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * The RequestController class is responsible for handling requests related to the Request entity.
 * It provides endpoints for creating, updating, and retrieving requests.
 * The class is annotated with @RestController to indicate that it is a controller class.
 * The class is annotated with @RequestMapping to specify the base URL path for all endpoints in the class.
 */
@RestController
@RequestMapping("/api/request")
public class RequestController {
    private final RequestService requestService;
    private final UserService userService;
    public RequestController(RequestService requestService, UserService userService) {
        this.requestService = requestService;
        this.userService = userService;
    }

    /**
     * Get all requests of the current user
     * @return - The list of requests
     */
    @PreAuthorize("hasAnyRole('TGL', 'PM', 'RM')")
    @GetMapping("/requests")
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
     * Get all requests of the current user
     * @return The list of requests
     */
    @PreAuthorize("hasAnyRole('CO')")
    @GetMapping("/co/requests")
    ResponseEntity<?> getAllRequestOfCO() {
        try {
            Optional<User> user = Optional.ofNullable(userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
            if (user.isPresent()) {
                List<RequestDTO> requests = requestService.getAllRequestOfCO(user.get().getUserId());
                return new ResponseEntity<>(requests,HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create a new request
     * @param requestDTO The request data
     * @return The created request
     */
    @PreAuthorize("hasRole('CO')")
    @PostMapping
    ResponseEntity<?> createRequest(
            @RequestPart("request") RequestDTO requestDTO,
            @RequestPart("images") List<MultipartFile> images
    ) {
        try {
            RequestDTO newRequest = requestService.createRequest(requestDTO, images);

            return new ResponseEntity<>(newRequest, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update a request by id with the new requestDTO data
     * @param requestDTO The new request data
     * @param id The id of the request to update
     * @return The updated request
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