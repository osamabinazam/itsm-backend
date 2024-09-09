package com.example.itsmbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sites")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Site {

    @Id
    private String id;

    @Column(unique = true)
    private int sideCode;

}
