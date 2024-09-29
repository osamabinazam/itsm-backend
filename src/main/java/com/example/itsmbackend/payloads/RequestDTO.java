package com.example.itsmbackend.payloads;

import com.example.itsmbackend.entity.Image;
import com.example.itsmbackend.entity.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The RequestDTO class represents a data transfer object for a Request entity.
 * It is used to transfer Request data between the frontend and backend.
 * The class is annotated with @Getter, @Setter, @AllArgsConstructor, and @NoArgsConstructor
 * to automatically generate the getters, setters, constructors, and no-args constructor.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    private Long id;
    private String faultDescription;
    private String status;
    private String type;
    private List<Image> imagePaths;
    private String currentLevel;
    private LocalDateTime submissionDate;
    private Long userId;
    private Long siteId;
    private Long forwardTo;
    private Long verifiedBy;
    private Long approvedBy;
    private Long forwardedBy;
    private Long nextAssignee;

    /**
     * Convert a Request entity to a RequestDTO
     * @param request The Request entity to convert
     * @param images The list of images to convert
     * @return The converted RequestDTO
     */
    public static RequestDTO toRequestDTO(Request request, List<Image> images) {

        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setId(request.getId());
        requestDTO.setFaultDescription(request.getFaultDescription());
        requestDTO.setStatus(request.getStatus().name());
        requestDTO.setType(request.getType().name());
        requestDTO.setImagePaths(images);
        requestDTO.setCurrentLevel(request.getCurrentLevel());
        requestDTO.setSubmissionDate(request.getSubmissionDate());
        requestDTO.setUserId(request.getUser().getUserId());
        requestDTO.setSiteId(request.getSite().getSiteId());

        if (request.getVerifiedBy() != null) {
            requestDTO.setVerifiedBy(request.getVerifiedBy().getUserId());
        }

        if (request.getApprovedBy() != null) {
            requestDTO.setApprovedBy(request.getApprovedBy().getUserId());
        }

        if (request.getForwardedBy() != null) {
            requestDTO.setForwardedBy(request.getForwardedBy().getUserId());
        }

        if (request.getNextAssignee() != null) {
            requestDTO.setNextAssignee(request.getNextAssignee().getUserId());
        }

        if (request.getForwardedTo() != null){
            requestDTO.setForwardTo(request.getForwardedTo().getUserId());
        }

        return requestDTO;
    }
}
