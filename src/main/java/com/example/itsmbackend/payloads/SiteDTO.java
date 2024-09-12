package com.example.itsmbackend.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SiteDTO {
    private Long siteId;
    private String siteName;
    private int siteCode;
}
