package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.Image;
import com.example.itsmbackend.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The ImageRepository interface is a repository for the Image entity.
 * It provides methods for accessing Image entities in the database.
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByRequest(Request request);
}
