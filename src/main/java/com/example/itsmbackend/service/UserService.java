package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.Role;
import com.example.itsmbackend.payloads.UserDTO;
import com.example.itsmbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User createUser(User user){
        user.setFullName(user.getFullName().toLowerCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findUserByEmail(String username){
        return userRepository.findByEmail(username);
    }

    public User findUserByFullName(String fullName){
        return userRepository.findByFullName(fullName.toLowerCase());
    }

    public List<UserDTO> getAllUsers() {
       List<User> users = userRepository.findAll();
       return users.stream().map(UserDTO::new).toList();
    }

    public List<UserDTO> getAllAdmins() {
        return userRepository.findAllByRoleOrderByFullName(Role.ADMIN).stream().map(UserDTO::new).toList();
    }
}
