package com.example.itsmbackend.entity;

import com.example.itsmbackend.entity.enums.RequestStatus;
import com.example.itsmbackend.entity.enums.RequestType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String faultDescription;

    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestType type;

    @Column(nullable = true)
    private String imagePath;

    @Column(nullable = false)
    private String currentLevel;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime submissionDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // CO who created the request

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private Site site;

    // Relations
    @ManyToOne
    @JoinColumn(name = "verified_by")
    private User verifiedBy;                     // TGL Who verifies the request

    @ManyToOne
    @JoinColumn(name="approved_by")
    private User approvedBy;

    @ManyToOne
    @JoinColumn(name = "forwarded_by")
    private User forwardedBy;

    @ManyToOne
    @JoinColumn(name = "next_assignee")
    private User nextAssignee;


}
