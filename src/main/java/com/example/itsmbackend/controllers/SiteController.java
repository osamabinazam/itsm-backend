package com.example.itsmbackend.controllers;


import com.example.itsmbackend.entity.Site;
import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.payloads.SiteDTO;
import com.example.itsmbackend.payloads.UserDTO;
import com.example.itsmbackend.service.SiteService;
import com.example.itsmbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @Autowired
    private UserService userService;


    /**
     * Get all users associated with a site
     * @param id
     * @return
     */
    @GetMapping("/{id}/users")
    ResponseEntity<?> getAllUsersBySiteId(@PathVariable Long id){
        try{
            Optional<Site> site = Optional.ofNullable(siteService.getSiteById(id));
            if (site.isPresent()){
                List<UserDTO> users = siteService.getUsersBySiteId(id);
                return new ResponseEntity<>(users,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Get site by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResponseEntity<?> getSiteById(@PathVariable Long id){
        try{
            Optional<Site> site = Optional.ofNullable(siteService.getSiteById(id));
            if (site.isPresent()){
                return new ResponseEntity<>(site,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Create a new site (Admin only)
     * @param site
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<?> createSite(@RequestBody SiteDTO site){
        try {
            Site createdSite = siteService.createSite(site);
            return new ResponseEntity<>(createdSite,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Delete a site by id (Admin only)
     * @param id
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteSite(@PathVariable String id){
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Udapte a site by id (Admin only)
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    ResponseEntity<?> updateSite(@RequestBody Site site, @PathVariable Long id){
        try {
            Site updatedSite = siteService.updateSite(site, id);
            if (updatedSite == null) {
                return new ResponseEntity<>("Site not found", HttpStatus.OK);
            }
            return new ResponseEntity<>(updatedSite, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Get all sites
     */
    @GetMapping
    ResponseEntity<?> getAllSites(){
        try {
            List<Site> sites = siteService.getAllSites();
            return new ResponseEntity<>(sites, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
