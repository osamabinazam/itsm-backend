package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * The UserRepository interface is a repository for the User entity.
 * It provides methods for accessing User entities in the database.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by email
     * @param email Email of the user
     * @return User object
     */
    User findByEmail (String email);

    /**
     * Find all users by role
     * @param role Role of the user
     * @return List of users
     */
    @Query("SELECT u.userId, u.email, u.fullName, u.role, u.supervisor FROM User u WHERE u.role = ?1  ORDER BY u.fullName")
    List<Object[]> findAllByRoleOrderByFullName(Role role);

}
