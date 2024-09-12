package com.example.itsmbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.itsmbackend")
public class ItsmBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItsmBackendApplication.class, args);
    }

}
