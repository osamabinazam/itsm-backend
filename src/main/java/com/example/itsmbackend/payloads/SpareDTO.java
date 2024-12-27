package com.example.itsmbackend.payloads;

import com.example.itsmbackend.entity.Spare;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SpareDTO {
    private Long id;


    private String itemCode;
    private String itemName;
    private String unit;
    private int quantity;
    private int approvedQuantity;

    /**
     * Convert SpareDetail entity to SpareDetailDTO
     * @param spareDetail The SpareDetail entity to convert
     * @return The converted SpareDetailDTO
     */
    public static SpareDTO toSpareDetailDTO(Spare spareDetail) {
        SpareDTO dto = new SpareDTO();
        dto.setId(spareDetail.getId());
        dto.setItemCode(spareDetail.getItemCode());
        dto.setItemName(spareDetail.getItemName());
        dto.setUnit(spareDetail.getUnit());
        dto.setQuantity(spareDetail.getQuantity());
        dto.setApprovedQuantity(spareDetail.getApprovedQuantity());
        return dto;
    }

}
