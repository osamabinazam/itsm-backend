package com.example.itsmbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "sites")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siteId;

    @Column(nullable = false)
    private String siteName;

    @Column(nullable = false)
    private int siteCode;


    @OneToMany(mappedBy = "site", fetch = FetchType.LAZY)
    private Set<Assignment> assignments;

    @OneToMany(mappedBy = "site", fetch = FetchType.LAZY)
    private Set<Request> requests;


    // Relations with other entities


}
