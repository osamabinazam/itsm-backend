package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.Assignment;
import com.example.itsmbackend.entity.Site;
import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.payloads.SiteDTO;
import com.example.itsmbackend.payloads.UserDTO;
import com.example.itsmbackend.repository.AssignmentRepository;
import com.example.itsmbackend.repository.SiteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The SiteService class is responsible for handling site-related operations.
 * It provides methods for creating, updating, and deleting sites.
 * The class is annotated with @Service to indicate that it is a service class.
 */
@Service
public class SiteService {

    private final SiteRepository siteRepository;

    private final AssignmentRepository assignmentRepository;

    public SiteService(SiteRepository siteRepository, AssignmentRepository assignmentRepository) {
        this.siteRepository = siteRepository;
        this.assignmentRepository = assignmentRepository;
    }

    /**
     * Create a new site
     * @param site SiteDTO object to create
     * @return Site object
     */
    public Site createSite(SiteDTO site){
        Site newSite = new Site();
        newSite.setSiteName(site.getSiteName());
        newSite.setSiteCode(site.getSiteCode());
        siteRepository.save(newSite);
        return newSite;

    }

    /**
     * Get all users associated with a site
     * @param siteId Site id to get users for
     * @return List of users
     */
    public List<UserDTO> getUsersBySiteId(Long siteId) {
        List<Assignment> assignments = assignmentRepository.findBySiteSiteId(siteId);
        List<UserDTO> userDTOs = new ArrayList<>();

        for (Assignment assignment : assignments) {
            User user = assignment.getUser();
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getUserId());
            userDTO.setFullName(user.getFullName());
            userDTO.setEmail(user.getEmail());
            userDTO.setRole(user.getRole().name());
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    /**
     * Get site by id
     * @param id Site id to get
     * @return Site object
     */
    public Site getSiteById(Long id){
        return siteRepository.findById(id).orElse(null);
    }


    /**
     * Update site by id
     * @param site Site object to update
     * @param id Site id to update
     * @return Updated site object
     */
    public Site updateSite(Site site, Long id){
        Optional<Site> siteInDb = siteRepository.findById(id);
        if(siteInDb.isPresent()) {
            Site siteToUpdate = siteInDb.get();
            siteToUpdate.setSiteName(site.getSiteName() != null ? site.getSiteName() : siteToUpdate.getSiteName());
            siteToUpdate.setSiteCode(site.getSiteCode() <= 0 ? site.getSiteCode() : siteToUpdate.getSiteCode());
            return siteRepository.save(siteToUpdate);
        }
        return null;
    }

    /**
     * Get all sites
     * @return List of sites
     */
    public List<Site> getAllSites(){
        return siteRepository.findAll();
    }



}
