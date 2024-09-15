package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {


    List<Request> findRequestsByForwardedToUserId(Long id);

    List<Request> findRequestsByUserUserId(Long id);
}
