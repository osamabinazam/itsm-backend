package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.Site;
import com.example.itsmbackend.payloads.SiteDTO;
import com.example.itsmbackend.repository.SiteRepository;
import com.fasterxml.jackson.databind.node.LongNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;


    public Site createSite(SiteDTO site){
        Site newSite = new Site();
        newSite.setSiteName(site.getSiteName());
        newSite.setSiteCode(site.getSiteCode());
        siteRepository.save(newSite);
        return newSite;

    }

    public void getSideById(Long id){
        siteRepository.findById(id);
    }

    public Site updateSite(Site site, Long id){
        Optional<Site> siteInDb = siteRepository.findById(id);
        if(siteInDb.isPresent()) {
            Site siteToUpdate = siteInDb.get();
            siteToUpdate.setSiteId(site.getSiteId() != null ? site.getSiteId() : siteToUpdate.getSiteId());
            siteToUpdate.setSiteCode(site.getSiteCode() <= 0 ? site.getSiteCode() : siteToUpdate.getSiteCode());
            return siteRepository.save(siteToUpdate);
        }
        return null;

    }

    public List<Site> getAllSites(){
        return siteRepository.findAll();
    }

    public void deleteSiteById(Long id){
        siteRepository.deleteById(id);
    }


}
