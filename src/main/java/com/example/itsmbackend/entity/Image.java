package com.example.itsmbackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Image class represents an image entity.
 * It is used to store image data in the database.
 * The class is annotated with @Entity and @Table to specify the database table to store the image data.
 * The class is annotated with @Id, @GeneratedValue, @Column, @ManyToOne, and @JoinColumn to specify the primary key,
 * auto-generation strategy, column, and relationship with the Request entity.
 * The class is annotated with @Setter and @Getter to automatically generate the setters and getters.
 */
@Entity
@Table(name = "images")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    @JsonBackReference
    private Request request;
}
