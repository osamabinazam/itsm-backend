package com.example.itsmbackend.entity;

import com.example.itsmbackend.entity.enums.Role;
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
    private Long id;

    @Column
    private String fullName;
    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Relations

    // One User  can have multiple site assigned
//    @OneToMany(mappedBy = "users" , cascade = CascadeType.ALL)
//    private List<Assignment> siteAssignments;
//
//    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
//    private  List<Request> requests;

}
