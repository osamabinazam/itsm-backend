package com.example.itsmbackend.controllers;

import com.example.itsmbackend.entity.Request;
import com.example.itsmbackend.entity.enums.RequestStatus;
import com.example.itsmbackend.entity.enums.RequestType;
import com.example.itsmbackend.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/request")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PreAuthorize("hasRole('CO')")
    @PostMapping
    ResponseEntity<?> addRequest(@RequestBody Request request) {
       try {
              requestService.createRequest(request);
              return new ResponseEntity<>(HttpStatus.OK);
         } catch (Exception e) {
              return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    @PutMapping
    ResponseEntity<?> updateRequest( @RequestBody Request request, @RequestParam Long id ) {
        try {
            Request updatedRequest = requestService.updateRequest(request, id);
            if (updatedRequest == null) {
                return new ResponseEntity<>("Request is already closed", HttpStatus.OK);
            }
            return new ResponseEntity<>(updatedRequest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    ResponseEntity<?> getAllRequest() {
        try {
            return new ResponseEntity<>(requestService.getAllRequests(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/:id")
    ResponseEntity<?> getRequest(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(requestService.getRequest(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
