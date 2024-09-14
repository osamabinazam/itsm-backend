package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.Assignment;
import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.Role;
import com.example.itsmbackend.payloads.SiteDTO;
import com.example.itsmbackend.payloads.UserDTO;
import com.example.itsmbackend.repository.AssignmentRepository;
import com.example.itsmbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Create a new user
     * @param user
     * @return
     */
    public User createUser(User user){
        user.setFullName(user.getFullName().toLowerCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUserId(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * Find user by email
     * @param username
     * @return
     */
    public User findUserByEmail(String username){
        return userRepository.findByEmail(username);
    }

    /**
     * Find user by full name
     * @param fullName
     * @return
     */
    public User findUserByFullName(String fullName){
        return userRepository.findByFullName(fullName.toLowerCase());
    }

    /**
     * Get all users
     * @return
     */
    public List<UserDTO> getAllUsers() {
       List<User> users = userRepository.findAll();
       return users.stream().map(UserDTO::new).toList();
    }

    /**
     * Get all admins
     * @return
     */
    public List<UserDTO> getAllAdmins() {
        return userRepository.findAllByRoleOrderByFullName(Role.ADMIN).stream().map(UserDTO::new).toList();
    }


    /**
     * Get all sites of the user
     * @param userId
     * @return
     */
    public List<SiteDTO> getAllUserSite(Long userId){

            List<Assignment> assignments = assignmentRepository.findDistinctByUserUserIdOrderBySite(userId);
            if (assignments.isEmpty()) {
                return null;
            }
            List<SiteDTO> siteDTOS = new ArrayList<>();
            for (Assignment assignment : assignments) {
                SiteDTO siteDTO = new SiteDTO();
                siteDTO.setSiteId(assignment.getSite().getSiteId());
                siteDTO.setSiteName(assignment.getSite().getSiteName());
                siteDTO.setSiteCode(assignment.getSite().getSiteCode());
                siteDTOS.add(siteDTO);
            }
            return siteDTOS;
    }

   /**
     * Fetch all supervisors of a given user, in a recursive manner.
     *
     * @param userId the ID of the user whose supervisors you want to retrieve
     * @return a List of UserDTO objects representing all supervisors in the hierarchy
     */
    public List<UserDTO> getAllSupervisors(Long userId) {
        List<UserDTO> supervisors = new ArrayList<>();
        User user = findByUserId(userId);                   // Get the user by ID
        while (user != null && user.getSupervisor() != null) {
            User supervisor = user.getSupervisor();         // Get the supervisor
            supervisors.add(new UserDTO(supervisor));       // Add the supervisor to the list
            user = supervisor;                              // Move up the chain to the next supervisor
        }
        return supervisors;
    }

    /**
     * fetch the supervisor of the user
     * */
    public UserDTO getSupervisor(Long userId) {
        User user = findByUserId(userId);
        if (user.getSupervisor() != null) {
            return new UserDTO(user.getSupervisor());
        }
        return null;
    }

}
