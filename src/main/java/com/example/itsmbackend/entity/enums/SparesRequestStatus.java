package com.example.itsmbackend.entity.enums;

public enum SparesRequestStatus {
    CREATED,
    FORWARDED_TO_TGL, // Forwarded to TGL
    REJECTED_BY_TGL,  // Rejected by TGL
    VERIFIED_BY_TGL,  // Verified by TGL
    FORWARDED_TO_RM,  // Forwarded to RM
    REJECTED_BY_RM,   // Rejected by RM
    APPROVED_BY_RM,   // Approved by RM
    FORWARDED_TO_MC,  // Forwarded to Material Coordinator
    CLOSED            // Request Closed
}
