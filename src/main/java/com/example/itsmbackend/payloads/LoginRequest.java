package com.example.itsmbackend.payloads;

import lombok.*;

/**
 * The LoginRequest class represents a data transfer object for a login request.
 * It is used to transfer login request data between the frontend and backend.
 * The class is annotated with @Getter, @Setter, @AllArgsConstructor, and @NoArgsConstructor
 * to automatically generate the getters, setters, constructors, and no-args constructor.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    private String email;
    private String password;
}
