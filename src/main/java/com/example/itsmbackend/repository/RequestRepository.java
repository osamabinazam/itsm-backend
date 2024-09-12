package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
