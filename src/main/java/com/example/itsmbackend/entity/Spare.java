package com.example.itsmbackend.entity;



import jakarta.persistence.*;
import lombok.*;
import com.example.itsmbackend.entity.SparesRequest;


@Entity
@Table(name = "spare_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Spare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private  String itemCode;
    @Column(nullable = false)
    private String itemName;
    @Column(nullable = false)
    private String unit;
    @Column(nullable = false)
    private  int quantity;
    @Column(nullable = false)
    private int approvedQuantity;

    // Link to spare request
    @ManyToOne
    @JoinColumn(name = "spares_request_id", nullable = false)
    private SparesRequest sparesRequest;


}
