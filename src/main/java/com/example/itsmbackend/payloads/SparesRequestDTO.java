package com.example.itsmbackend.payloads;

import com.example.itsmbackend.entity.SparesRequest;
import com.example.itsmbackend.entity.enums.Role;
import com.example.itsmbackend.entity.enums.SparesRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for SparesRequest entity.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SparesRequestDTO {

    private Long id;
    private Role currentLevel;
    private String remarks;
    private boolean isClosed;
    private  Long requestId;
    private SparesRequestStatus status;
    private List<SpareDTO> spares;

    private Long verifiedByTGLId;
    private Long approvedByRMId;
    private Long verifiedByMCId;

    private Long createdById;
    private Long nextAssigneeId;


    /**
     * Convert SparesRequest entity to SparesRequestDTO
     * @param sparesRequest The SparesRequest entity to convert
     * @return The converted SparesRequestDTO
     */
    public static SparesRequestDTO toSparesRequestDTO(SparesRequest sparesRequest) {
        SparesRequestDTO dto = new SparesRequestDTO();
        dto.setId(sparesRequest.getId());
        dto.setRequestId(sparesRequest.getRequest().getId());
        dto.setCurrentLevel(sparesRequest.getCurrentLevel());
        dto.setRemarks(sparesRequest.getRemarks());
        dto.setClosed(sparesRequest.isClosed());
        dto.setStatus(sparesRequest.getStatus());
        dto.setCreatedById(sparesRequest.getCreatedBy().getUserId());
        dto.setNextAssigneeId(sparesRequest.getNextAssignee().getUserId());
        dto.setVerifiedByTGLId(sparesRequest.getVerifiedByTGL() != null ? sparesRequest.getVerifiedByTGL().getUserId() : null);
        dto.setApprovedByRMId(sparesRequest.getApprovedByRM() != null ? sparesRequest.getApprovedByRM().getUserId(): null);
        dto.setVerifiedByMCId(sparesRequest.getVerifiedByMC() != null ? sparesRequest.getVerifiedByMC().getUserId(): null);
        dto.setSpares(sparesRequest.getSpares().stream()
                .map(SpareDTO::toSpareDetailDTO)
                .collect(Collectors.toList()));
        return dto;
    }
}
