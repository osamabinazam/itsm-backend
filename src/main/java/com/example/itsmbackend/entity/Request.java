package com.example.itsmbackend.entity;

import com.example.itsmbackend.entity.enums.RequestStatus;
import com.example.itsmbackend.entity.enums.RequestType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false)
    private String faultDescription;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestType type;

    // One-to-Many relationship with Image entity
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    @Column(nullable = false)
    private String currentLevel;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime submissionDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    @JsonIgnore
    private Site site;

    @ManyToOne
    @JoinColumn(name = "verified_by")
    @JsonIgnore
    private User verifiedBy;

    @ManyToOne
    @JoinColumn(name = "forwarded_to")
    @JsonIgnore
    private User forwardedTo;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    @JsonIgnore
    private User approvedBy;

    @ManyToOne
    @JoinColumn(name = "forwarded_by")
    @JsonIgnore
    private User forwardedBy;

    @ManyToOne
    @JoinColumn(name = "next_assignee")
    @JsonIgnore
    private User nextAssignee;

}
