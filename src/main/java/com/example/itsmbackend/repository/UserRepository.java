package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail (String email);
    User findByFullName(String fullName);
    @Query("SELECT u.userId, u.email, u.fullName, u.role, u.supervisor FROM User u WHERE u.role = ?1  ORDER BY u.fullName")
    List<Object[]> findAllByRoleOrderByFullName(Role role);

}
