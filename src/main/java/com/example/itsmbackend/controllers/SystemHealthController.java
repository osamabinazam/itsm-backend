package com.example.itsmbackend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/api/health")
public class SystemHealthController {


    @GetMapping
    String healthCheck(){
        return "System is up and running.";
    }
}
