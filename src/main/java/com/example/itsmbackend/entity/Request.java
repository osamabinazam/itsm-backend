package com.example.itsmbackend.entity;

import com.example.itsmbackend.entity.enums.RequestStatus;
import com.example.itsmbackend.entity.enums.RequestType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String faultDescription;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestType type;

    private LocalDateTime submissionDate = LocalDateTime.now() ;
}
