package com.example.itsmbackend.entity;

import com.example.itsmbackend.entity.enums.Role;
import com.example.itsmbackend.entity.enums.SparesRequestStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "spares_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SparesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role currentLevel; // Current approval level (CO, TGL, RM, etc.)

    @Column
    private String remarks; // Any remarks made during approval/rejection

    @Column
    private boolean isClosed; // Indicates if the request is finalized
    // Link to Spare Entity
    @OneToMany(mappedBy = "sparesRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Spare> spares;

    // Link to the main Request entity
    @OneToOne
    @JoinColumn(name = "request_id", nullable = false, unique = true)
    private Request request;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SparesRequestStatus status;

    @ManyToOne
    @JoinColumn(name = "verified_by_tgl")
    private User verifiedByTGL;

    @ManyToOne
    @JoinColumn(name = "approved_by_rm")
    private User approvedByRM;

    @ManyToOne
    @JoinColumn(name = "verified_by_mc")
    private User verifiedByMC;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "next_assignee", nullable = false)
    private  User nextAssignee;



}
