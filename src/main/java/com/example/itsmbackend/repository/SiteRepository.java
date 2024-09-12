package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<Site, Long> {
    Site findBySiteName(String siteName);
    Site findBySiteCode(int siteCode);
}
