package com.example.itsmbackend.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The SiteDTO class represents a data transfer object for a Site entity.
 * It is used to transfer Site data between the frontend and backend.
 * The class is annotated with @Getter, @Setter, @AllArgsConstructor, and @NoArgsConstructor
 * to automatically generate the getters, setters, constructors, and no-args constructor.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SiteDTO {
    private Long siteId;
    private String siteName;
    private int siteCode;
}
