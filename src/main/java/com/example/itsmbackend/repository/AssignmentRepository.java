package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The AssignmentRepository interface is a repository for the Assignment entity.
 * It provides methods for accessing Assignment entities in the database.
 */
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {


    /**
     * Find all assignments for a particular user
     * @param userId ID of the user
     * @return List of assignments
     */
    List<Assignment> findDistinctByUserUserIdOrderBySite(Long userId);


    /**
     * Find all assignments for a particular site
     * @param siteId ID of the site
     * @return List of assignments
     */
    List<Assignment> findBySiteSiteId(Long siteId);
}
