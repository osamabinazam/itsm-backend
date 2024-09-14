package com.example.itsmbackend.entity;

import com.example.itsmbackend.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String fullName;

    @Column(unique = true)
    private String email;
    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Relations

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "supervisor_id")
    @JsonIgnore
    private User supervisor;

    // One User  can have multiple site assigned
    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Assignment> siteAssignments;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JsonIgnore
    private  List<Request> requests;

}
