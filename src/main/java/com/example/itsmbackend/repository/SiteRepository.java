package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.Site;
import com.example.itsmbackend.payloads.SiteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * The SiteRepository interface is a repository for the Site entity.
 * It provides methods for accessing Site entities in the database.
 */
public interface SiteRepository extends JpaRepository<Site, Long> {
    Site findBySiteName(String siteName);
    Site findBySiteCode(int siteCode);

    @Query ("SELECT siteId,siteCode FROM Site WHERE siteId = ?1")
    Site findSiteById(Long siteId);

}
