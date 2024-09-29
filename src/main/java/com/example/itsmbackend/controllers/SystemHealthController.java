package com.example.itsmbackend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The SystemHealthController class is a REST controller that provides an endpoint for checking the system health.
 * The endpoint is accessible to the public and does not require authentication.
 */
@RestController
@RequestMapping("/public/api/health")
public class SystemHealthController {


    @GetMapping
    String healthCheck(){
        return "System is up and running.";
    }
}
