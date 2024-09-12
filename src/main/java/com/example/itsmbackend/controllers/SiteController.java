package com.example.itsmbackend.controllers;


import com.example.itsmbackend.entity.Site;
import com.example.itsmbackend.payloads.SiteDTO;
import com.example.itsmbackend.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @GetMapping
    List<Site> getSites(){
        List<Site> sites = new ArrayList<>();
        return sites;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/:id")
    ResponseEntity<?> getSite(@RequestParam String id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> createSite(@RequestBody SiteDTO site){
        try {
            Site createdSite = siteService.createSite(site);
            return new ResponseEntity<>(createdSite,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/:id")
    ResponseEntity<?> deleteSite(@RequestParam String id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
