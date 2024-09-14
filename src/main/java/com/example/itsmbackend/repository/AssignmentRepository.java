package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {


    // Method to find all assignments for a particular user
    List<Assignment> findDistinctByUserUserIdOrderBySite(Long userId);

    // Method to find associated site to the user
    List<Assignment> findDistinctBySiteSiteIdOrderByUser(Long siteId);

    // Method to find all assignments for a particular site
    List<Assignment> findBySiteSiteId(Long siteId);
}
