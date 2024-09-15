package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.Request;
import com.example.itsmbackend.entity.Site;
import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.RequestStatus;
import com.example.itsmbackend.entity.enums.RequestType;
import com.example.itsmbackend.payloads.RequestDTO;
import com.example.itsmbackend.repository.RequestRepository;
import com.example.itsmbackend.repository.SiteRepository;
import com.example.itsmbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for Request entity
 */

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired UserService userService;

    public RequestDTO createRequest(RequestDTO requestDTO) {
        // Fetch the User who is creating the request
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + requestDTO.getUserId()));

        // Fetch the Site associated with the request
        Site site = siteRepository.findById(requestDTO.getSiteId())
                .orElseThrow(() -> new RuntimeException("Site not found with ID: " + requestDTO.getSiteId()));

        User forwardTo = userRepository.findById(requestDTO.getForwardTo()).
                orElseThrow(() -> new RuntimeException(("User not found with ID : " + requestDTO.getForwardTo())));
        // Create a new Request entity from the DTO
        Request newRequest = new Request();
        newRequest.setFaultDescription(requestDTO.getFaultDescription());
        newRequest.setType(RequestType.valueOf(requestDTO.getType()));
        newRequest.setStatus(RequestStatus.valueOf(requestDTO.getStatus()));
        newRequest.setImagePath(requestDTO.getImagePath());
        newRequest.setCurrentLevel(requestDTO.getCurrentLevel());
        newRequest.setSubmissionDate(LocalDateTime.now());

        // Set the user and site in the request
        newRequest.setUser(user);
        newRequest.setSite(site);
        newRequest.setForwardedTo(forwardTo);

        // If there are any verification/approval/forwarded/next_assignee users, handle them (optional)
        if (requestDTO.getVerifiedBy() != null) {
            User verifiedBy = userRepository.findById(requestDTO.getVerifiedBy())
                    .orElseThrow(() -> new RuntimeException("Verified user not found"));
            newRequest.setVerifiedBy(verifiedBy);
        }

        if (requestDTO.getApprovedBy() != null) {
            User approvedBy = userRepository.findById(requestDTO.getApprovedBy())
                    .orElseThrow(() -> new RuntimeException("Approved user not found"));
            newRequest.setApprovedBy(approvedBy);
        }

        if (requestDTO.getForwardedBy() != null) {
            User forwardedBy = userRepository.findById(requestDTO.getForwardedBy())
                    .orElseThrow(() -> new RuntimeException("Forwarded user not found"));
            newRequest.setForwardedBy(forwardedBy);
        }

        if (requestDTO.getNextAssignee() != null) {
            User nextAssignee = userRepository.findById(requestDTO.getNextAssignee())
                    .orElseThrow(() -> new RuntimeException("Next assignee user not found"));
            newRequest.setNextAssignee(nextAssignee);
        }


        // Save the request to the database
        Request savedRequest = requestRepository.save(newRequest);

        // Convert the saved Request entity back to a RequestDTO to return it
        RequestDTO responseDTO = new RequestDTO();
        responseDTO.setId(savedRequest.getId());
        responseDTO.setFaultDescription(savedRequest.getFaultDescription());
        responseDTO.setStatus(savedRequest.getStatus().name());
        responseDTO.setType(savedRequest.getType().name());
        responseDTO.setImagePath(savedRequest.getImagePath());
        responseDTO.setCurrentLevel(savedRequest.getCurrentLevel());
        responseDTO.setSubmissionDate(savedRequest.getSubmissionDate());
        responseDTO.setUserId(savedRequest.getUser().getUserId());
        responseDTO.setSiteId(savedRequest.getSite().getSiteId());

        if (savedRequest.getVerifiedBy() != null) {
            responseDTO.setVerifiedBy(savedRequest.getVerifiedBy().getUserId());
        }

        if (savedRequest.getApprovedBy() != null) {
            responseDTO.setApprovedBy(savedRequest.getApprovedBy().getUserId());
        }

        if (savedRequest.getForwardedBy() != null) {
            responseDTO.setForwardedBy(savedRequest.getForwardedBy().getUserId());
        }

        if (savedRequest.getNextAssignee() != null) {
            responseDTO.setNextAssignee(savedRequest.getNextAssignee().getUserId());
        }

        if (savedRequest.getForwardedTo() != null){
            responseDTO.setForwardTo(savedRequest.getForwardedTo().getUserId());
        }

        return responseDTO;
    }




    public RequestDTO updateRequest( RequestDTO requestDTO ,long id) {
        Optional<Request> requestInDb = findRequestById(id);
        if (requestInDb.isPresent()) {
            if (RequestStatus.valueOf(String.valueOf(requestInDb.get().getStatus())) != RequestStatus.APPROVED) {

                    requestInDb.get().setStatus( requestDTO.getStatus() != null ? RequestStatus.valueOf(requestDTO.getStatus()) : requestInDb.get().getStatus());
                    requestInDb.get().setVerifiedBy(requestDTO.getVerifiedBy() != null ? userService.findByUserId(requestDTO.getVerifiedBy()) : requestInDb.get().getVerifiedBy());
                    requestInDb.get().setApprovedBy(requestDTO.getApprovedBy() != null ? userService.findByUserId(requestDTO.getApprovedBy()) : requestInDb.get().getApprovedBy());
                    requestInDb.get().setForwardedTo(requestDTO.getForwardTo() != null ? userService.findByUserId(requestDTO.getForwardTo()) : requestInDb.get().getForwardedTo());
                    requestInDb.get().setCurrentLevel(requestDTO.getCurrentLevel()!= null ? requestDTO.getCurrentLevel() : requestInDb.get().getCurrentLevel());
                    requestInDb.get().setNextAssignee(requestDTO.getNextAssignee() != null ? userService.findByUserId(requestDTO.getNextAssignee()) : requestInDb.get().getNextAssignee());

                    Request updatedRequest = requestRepository.save(requestInDb.get());

                    // Now return the DTo
                    RequestDTO responseDTO = new RequestDTO();
                    responseDTO.setId(updatedRequest.getId());
                    responseDTO.setFaultDescription(updatedRequest.getFaultDescription());
                    responseDTO.setStatus(updatedRequest.getStatus().name());
                    responseDTO.setType(updatedRequest.getType().name());
                    responseDTO.setImagePath(updatedRequest.getImagePath());
                    responseDTO.setCurrentLevel(updatedRequest.getCurrentLevel());
                    responseDTO.setUserId(updatedRequest.getUser().getUserId());
                    responseDTO.setSiteId(updatedRequest.getSite().getSiteId());
                    responseDTO.setSubmissionDate(updatedRequest.getSubmissionDate());
                    responseDTO.setForwardTo(updatedRequest.getForwardedTo() != null ? updatedRequest.getForwardedTo().getUserId() : null);
                    responseDTO.setVerifiedBy(updatedRequest.getVerifiedBy() != null ? updatedRequest.getVerifiedBy().getUserId() : null);
                    responseDTO.setApprovedBy(updatedRequest.getApprovedBy() != null ? updatedRequest.getApprovedBy().getUserId() : null);
                    responseDTO.setForwardedBy(updatedRequest.getForwardedBy() != null ? updatedRequest.getForwardedBy().getUserId() : null);
                    responseDTO.setNextAssignee(updatedRequest.getNextAssignee() != null ? updatedRequest.getNextAssignee().getUserId() : null);

                    return responseDTO;
            }
            else {
                return null;
            }

        } else {
            return null;

        }

    }

    /**
     *
     * @param id
     * @return
     */
   /**
     * Get all requests for a user based on their role
     * @param userId - the ID of the user (TGL, RM, or PM)
     * @param role - the role of the user
     * @return List of RequestDTOs
     */
    public List<RequestDTO> getAllRequestOfUser(Long userId, String role) {
        List<Request> requests = requestRepository.findRequestsByForwardedToUserId(userId);
        if (requests != null) {
            List<RequestDTO> requestDTOS = new ArrayList<>();
            for (Request request : requests) {
                // Skip requests that are already approved
                if (request.getStatus() == RequestStatus.APPROVED) {
                    continue;
                }

                // Role-specific logic
                if (role.equals("TGL")) {
                    // TGL should not see requests forwarded to RM
                    if (request.getStatus() == RequestStatus.PENDING && request.getForwardedTo() != null && request.getForwardedTo().getRole().equals("RM")) {
                        continue;
                    }
                } else if (role.equals("RM")) {
                    // RM should see requests forwarded to them but not yet approved
                    if (( request.getStatus() == RequestStatus.VERIFIED) &&
                         request.getForwardedTo() != null && request.getForwardedTo().getUserId().equals(userId)) {
                        // Allow RM to view requests
                    } else {
                        continue;
                    }
                } else if (role.equals("PM")) {
                    // PM should only see requests forwarded by RM and not yet approved
                    if (request.getStatus() == RequestStatus.VERIFIED &&
                        request.getForwardedTo() != null && request.getForwardedTo().getRole().equals("PM")) {
                        // Allow PM to view requests
                    } else {
                        continue;
                    }
                }

                // Convert Request entity to RequestDTO
                RequestDTO requestDTO = new RequestDTO();
                requestDTO.setId(request.getId());
                requestDTO.setFaultDescription(request.getFaultDescription());
                requestDTO.setStatus(request.getStatus().name());
                requestDTO.setType(request.getType().name());
                requestDTO.setImagePath(request.getImagePath());
                requestDTO.setCurrentLevel(request.getCurrentLevel());
                requestDTO.setSubmissionDate(request.getSubmissionDate());
                requestDTO.setUserId(request.getUser().getUserId());
                requestDTO.setSiteId(request.getSite().getSiteId());
                requestDTO.setForwardTo(request.getForwardedTo() != null ? request.getForwardedTo().getUserId() : null);
                requestDTO.setVerifiedBy(request.getVerifiedBy() != null ? request.getVerifiedBy().getUserId() : null);
                requestDTO.setApprovedBy(request.getApprovedBy() != null ? request.getApprovedBy().getUserId() : null);
                requestDTO.setForwardedBy(request.getForwardedBy() != null ? request.getForwardedBy().getUserId() : null);
                requestDTO.setNextAssignee(request.getNextAssignee() != null ? request.getNextAssignee().getUserId() : null);
                requestDTOS.add(requestDTO);
            }
            return requestDTOS;
        }
        return null;
    }


    public boolean deleteRequest(long id) {
        Optional<Request> requestInDb = requestRepository.findById(id);
        if (requestInDb.isPresent()) {
            requestRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get request by id
     *
     * @return
     */
    public Optional<Request> getRequest(long id){
        return requestRepository.findById(id);
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Optional<Request> findRequestById(Long id) {
        return requestRepository.findById(id);
    }

    /**
     * Get all requests of a user
     */

}
