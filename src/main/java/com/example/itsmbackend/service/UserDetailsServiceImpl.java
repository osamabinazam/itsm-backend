package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * The UserDetailsServiceImpl class is responsible for loading user details from the database.
 * It implements the UserDetailsService interface provided by Spring Security.
 * The class is annotated with @Service to indicate that it is a service class.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Constructs a new UserDetailsServiceImpl with the given UserRepository.
     *
     * @param userRepository The UserRepository to use for user operations.
     */
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Loads user details from the database using the given email.
     *
     * @param email The email of the user to load.
     * @return A UserDetails object representing the user.
     * @throws UsernameNotFoundException If the user is not found in the database.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null){
            return org.springframework.security.core.userdetails.User
                    .builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(String.valueOf(user.getRole()))
                    .build();
        }
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
