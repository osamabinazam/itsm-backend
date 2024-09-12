package com.example.itsmbackend.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private Long id;
    private String faultDescription;
    private String status;
    private String type;
    private String imagePath;
    private String currentLevel;
    private LocalDateTime submissionDate;
    private Long userId;
    private Long siteId;
    private Long verifiedBy;
    private Long approvedBy;
    private Long forwardedBy;
    private Long nextAssignee;

}

