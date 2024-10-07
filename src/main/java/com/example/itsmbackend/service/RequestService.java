package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.Image;
import com.example.itsmbackend.entity.Request;
import com.example.itsmbackend.entity.Site;
import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.RequestStatus;
import com.example.itsmbackend.entity.enums.RequestType;
import com.example.itsmbackend.payloads.RequestDTO;
import com.example.itsmbackend.repository.RequestRepository;
import com.example.itsmbackend.repository.SiteRepository;
import com.example.itsmbackend.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for handling business logic related to Requests.
 */
@Service
public class RequestService {

    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final SiteRepository siteRepository;
    private final UserService userService;
    private final ImageService imageService;

    public RequestService(RequestRepository requestRepository, UserRepository userRepository,
                          SiteRepository siteRepository, UserService userService,
                          ImageService imageService) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.siteRepository = siteRepository;
        this.userService = userService;
        this.imageService = imageService;
    }

    /**
     * Creates a new request and saves the associated images.
     *
     * @param requestDTO The request data transfer object containing the request details.
     * @param images     List of images (if any) to be associated with the request.
     * @return The created RequestDTO with images.
     */
    public RequestDTO createRequest(RequestDTO requestDTO, List<MultipartFile> images) throws IOException {
        // Fetch the user creating the request
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + requestDTO.getUserId()));

        // Fetch the associated site
        Site site = siteRepository.findById(requestDTO.getSiteId())
                .orElseThrow(() -> new RuntimeException("Site not found with ID: " + requestDTO.getSiteId()));

        // Fetch the user to whom the request is forwarded
        User forwardTo = userRepository.findById(requestDTO.getForwardTo())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + requestDTO.getForwardTo()));

        // Convert the RequestDTO to a Request entity
        Request newRequest = toRequest(requestDTO, user, site, forwardTo);

        // Save the request entity to the database
        Request savedRequest = requestRepository.save(newRequest);

        // Save associated images, if any
        List<Image> savedImages = new ArrayList<>();
        if (images != null && !images.isEmpty()) {
            savedImages = imageService.storeImages(images, savedRequest);
        }

        // Return the DTO including the public URLs of the images
        return RequestDTO.toRequestDTO(savedRequest, savedImages);
    }

    /**
     * Updates an existing request.
     *
     * @param requestDTO The updated request data.
     * @param id         The ID of the request to update.
     * @return The updated RequestDTO.
     */
    public RequestDTO updateRequest(RequestDTO requestDTO, long id) {
        Optional<Request> requestInDb = findRequestById(id);

        if (requestInDb.isPresent() &&
            requestInDb.get().getStatus() != RequestStatus.APPROVED) {
            Request request = requestInDb.get();

            // Update fields from the requestDTO
            request.setStatus(requestDTO.getStatus() != null ? RequestStatus.valueOf(requestDTO.getStatus()) : request.getStatus());
            request.setVerifiedBy(requestDTO.getVerifiedBy() != null ? userService.findByUserId(requestDTO.getVerifiedBy()) : request.getVerifiedBy());
            request.setApprovedBy(requestDTO.getApprovedBy() != null ? userService.findByUserId(requestDTO.getApprovedBy()) : request.getApprovedBy());
            request.setForwardedTo(requestDTO.getForwardTo() != null ? userService.findByUserId(requestDTO.getForwardTo()) : request.getForwardedTo());
            request.setForwardedBy(requestDTO.getForwardedBy() != null ? userService.findByUserId(requestDTO.getForwardedBy()) : request.getForwardedBy());
            request.setCurrentLevel(requestDTO.getCurrentLevel() != null ? requestDTO.getCurrentLevel() : request.getCurrentLevel());
            request.setNextAssignee(requestDTO.getNextAssignee() != null ? userService.findByUserId(requestDTO.getNextAssignee()) : null);

            // Save updated request to the database
            Request updatedRequest = requestRepository.save(request);

            // Retrieve the associated images
            List<Image> images = imageService.getImagesByRequest(updatedRequest);
            return RequestDTO.toRequestDTO(updatedRequest, images);
        }

        return null; // Request is already approved, no updates allowed
    }

    /**
     * Retrieves all requests for a user based on their role.
     *
     * @param userId The ID of the user.
     * @param role   The role of the user (e.g., TGL, RM, PM).
     * @return List of RequestDTOs for the user.
     */
    public List<RequestDTO> getAllRequestOfUser(Long userId, String role) {
        List<Request> requests = requestRepository.findRequestsByForwardedToUserId(userId);
        List<RequestDTO> requestDTOS = new ArrayList<>();

        if (requests != null) {
            for (Request request : requests) {
                List<Image> images = imageService.getImagesByRequest(request);

                // Always show requests created by the logged-in user (CO)
                if (request.getUser().getUserId().equals(
                        userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getUserId())) {
                    requestDTOS.add(RequestDTO.toRequestDTO(request, images));
                    continue;
                }

                // Role-specific filtering logic
                switch (role) {
                    case "TGL" -> {
                        if (request.getStatus() == RequestStatus.PENDING &&
                            request.getForwardedTo() != null &&
                            "RM".equals(request.getForwardedTo().getRole())) {
                            continue;
                        }
                    }
                    case "RM" -> {
                        if (request.getStatus() != RequestStatus.VERIFIED ||
                            request.getForwardedTo() == null ||
                            !request.getForwardedTo().getUserId().equals(userId)) {
                            continue;
                        }
                    }
                    case "PM" -> {
                        if (request.getStatus() != RequestStatus.VERIFIED ||
                            request.getForwardedTo() == null ||
                            !request.getForwardedTo().getUserId().equals(userId) ||
                            !"PM".equals(request.getCurrentLevel())) {
                            continue;
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + role);
                }
                requestDTOS.add(RequestDTO.toRequestDTO(request, images));
            }
        }
        return requestDTOS;
    }

    /**
     * Retrieves all requests created by a specific user (CO).
     *
     * @param id The ID of the CO.
     * @return List of RequestDTOs created by the CO.
     */
    public List<RequestDTO> getAllRequestOfCO(Long id) {
        List<Request> requests = requestRepository.findRequestsByUserUserId(id);
        List<RequestDTO> requestDTOS = new ArrayList<>();

        if (requests != null) {
            for (Request request : requests) {
                List<Image> images = imageService.getImagesByRequest(request);
                requestDTOS.add(RequestDTO.toRequestDTO(request, images));
            }
        }
        return requestDTOS;
    }

    /**
     * Deletes a request by ID.
     *
     * @param id The ID of the request to delete.
     * @return True if the request was deleted, false otherwise.
     */
    public boolean deleteRequest(long id) {
        Optional<Request> requestInDb = requestRepository.findById(id);
        if (requestInDb.isPresent()) {
            requestRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Finds a request by its ID.
     *
     * @param id The ID of the request.
     * @return The found request or empty if not found.
     */
    public Optional<Request> findRequestById(Long id) {
        return requestRepository.findById(id);
    }

    /**
     * Converts a RequestDTO to a Request entity.
     *
     * @param requestDTO The request DTO.
     * @param user       The user associated with the request.
     * @param site       The site associated with the request.
     * @param forwardTo  The user to whom the request is forwarded.
     * @return The Request entity.
     */
    private static Request toRequest(RequestDTO requestDTO, User user, Site site, User forwardTo) {
        Request request = new Request();
        request.setFaultDescription(requestDTO.getFaultDescription());
        request.setStatus(RequestStatus.valueOf(requestDTO.getStatus()));
        request.setType(RequestType.valueOf(requestDTO.getType()));
        request.setCurrentLevel(requestDTO.getCurrentLevel());
        request.setSubmissionDate(requestDTO.getSubmissionDate());
        request.setUser(user);
        request.setSite(site);
        request.setForwardedTo(forwardTo);
        setRoles(request, requestDTO);
        return request;
    }

    /**
     * Sets roles (VerifiedBy, ApprovedBy, ForwardedBy, etc.) in the Request entity based on the RequestDTO.
     *
     * @param request    The Request entity.
     * @param requestDTO The RequestDTO.
     */
    private static void setRoles(Request request, RequestDTO requestDTO) {
        if (requestDTO.getVerifiedBy() != null) {
            User verifiedBy = new User();
            verifiedBy.setUserId(requestDTO.getVerifiedBy());
            request.setVerifiedBy(verifiedBy);
        }

        if (requestDTO.getApprovedBy() != null) {
            User approvedBy = new User();
            approvedBy.setUserId(requestDTO.getApprovedBy());
            request.setApprovedBy(approvedBy);
        }

        if (requestDTO.getForwardedBy() != null) {
            User forwardedBy = new User();
            forwardedBy.setUserId(requestDTO.getForwardedBy());
            request.setForwardedBy(forwardedBy);
        }

        if (requestDTO.getNextAssignee() != null) {
            User nextAssignee = new User();
            nextAssignee.setUserId(requestDTO.getNextAssignee());
            request.setNextAssignee(nextAssignee);
        }
    }
}
