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
 * Service class for Request entity to handle business logic and data manipulation for requests
 * @see Request for the entity
 * @see RequestRepository for the repository
 * @see UserService for the service
 * @see ImageService for the service
 * @see UserRepository for the repository
 * @see SiteRepository for the repository
 * @see User for the entity
 * @see Site for the entity
 * @see Image for the entity
 */
@Service
public class RequestService {

    private final RequestRepository requestRepository;

    private final UserRepository userRepository;

    private final SiteRepository siteRepository;

    final UserService userService;

    final ImageService imageService;

    /**
     * Constructor for RequestService class
     * @param requestRepository - the repository for Request entity
     * @param userRepository - the repository for User entity
     * @param siteRepository - the repository for Site entity
     * @param userService - the service for User entity
     * @param imageService - the service for Image entity
     */
    public RequestService(RequestRepository requestRepository, UserRepository userRepository, SiteRepository siteRepository, UserService userService, ImageService imageService) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.siteRepository = siteRepository;
        this.userService = userService;
        this.imageService = imageService;
    }

    /**
     * Create a new request from a RequestDTO and a list of images (if any) and save it to the database
     * @param requestDTO - the request data
     * @param images - the list of images
     * @return - The created request
     */
    public RequestDTO createRequest(RequestDTO requestDTO, List<MultipartFile> images) throws IOException {
        // Fetch the User who is creating the request
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + requestDTO.getUserId()));

        // Fetch the Site associated with the request
        Site site = siteRepository.findById(requestDTO.getSiteId())
                .orElseThrow(() -> new RuntimeException("Site not found with ID: " + requestDTO.getSiteId()));

        User forwardTo = userRepository.findById(requestDTO.getForwardTo()).
                orElseThrow(() -> new RuntimeException(("User not found with ID : " + requestDTO.getForwardTo())));
        // Create a new Request entity from the DTO
        Request newRequest = toRequest(requestDTO, user, site, forwardTo);

        List<Image> savedImages = new ArrayList<>();
        // Save the request to the database
        Request savedRequest = requestRepository.save(newRequest);
        if (images != null){
            savedImages = imageService.storeImages(images, savedRequest);
        }
        return RequestDTO.toRequestDTO(savedRequest, savedImages);
    }

    /**
     * Update a request by ID
     * @param requestDTO - the updated request data
     * @param id - the ID of the request to update
     * @return The updated request
     */
    public RequestDTO updateRequest( RequestDTO requestDTO ,long id) {
        Optional<Request> requestInDb = findRequestById(id);
        Request request = requestInDb.orElse(null);

        if (requestInDb.isPresent() && RequestStatus.valueOf(String.valueOf(requestInDb.get().getStatus())) != RequestStatus.APPROVED) {

                request.setStatus(requestDTO.getStatus() != null ? RequestStatus.valueOf(requestDTO.getStatus()) : request.getStatus());
                request.setVerifiedBy(requestDTO.getVerifiedBy() != null ? userService.findByUserId(requestDTO.getVerifiedBy()) : request.getVerifiedBy());
                request.setApprovedBy(requestDTO.getApprovedBy() != null ? userService.findByUserId(requestDTO.getApprovedBy()) : request.getApprovedBy());
                request.setForwardedTo(requestDTO.getForwardTo() != null ? userService.findByUserId(requestDTO.getForwardTo()) : request.getForwardedTo());
                request.setForwardedBy(requestDTO.getForwardedBy() != null ? userService.findByUserId(requestDTO.getForwardedBy()) : request.getForwardedBy());
                request.setCurrentLevel(requestDTO.getCurrentLevel() != null ? requestDTO.getCurrentLevel() : request.getCurrentLevel());
                request.setNextAssignee(requestDTO.getNextAssignee() != null ? userService.findByUserId(requestDTO.getNextAssignee()) :null);

                Request updatedRequest = requestRepository.save(request);

                // Find All Images for the request
                List<Image> images = imageService.getImagesByRequest(updatedRequest);
                if (images == null) {
                    images = new ArrayList<>();
                }
                return RequestDTO.toRequestDTO(updatedRequest, images);
            }

        return null;
    }


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

                // Find All Images for the request
                List<Image> images = imageService.getImagesByRequest(request);
                if (images == null) {
                    images = new ArrayList<>();
                }

                // Allow the CO (creator of the request) to always see the request, regardless of status
                if (request.getUser().getUserId().equals(
                        userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getUserId()
                )) {
                    requestDTOS.add(RequestDTO.toRequestDTO(request, images));
                    continue;
                }

                // Role-specific logic
                switch (role) {
                    case "TGL" -> {
                        // TGL should not see requests forwarded to RM
                        if (request.getStatus() == RequestStatus.PENDING && request.getForwardedTo() != null && request.getForwardedTo().getRole().equals("RM")) {
                            continue;
                        }
                    }
                    case "RM" -> {
                        // RM should see requests forwarded to them but not yet approved
                        if ((request.getStatus() != RequestStatus.VERIFIED) ||
                                request.getForwardedTo() == null || !request.getForwardedTo().getUserId().equals(userId)) {
                                    continue;
                        }
                    }
                    case "PM" -> {
                        // PM should only see requests forwarded by RM and not yet approved
                        if (request.getStatus() != RequestStatus.VERIFIED || request.getForwardedTo() == null || !request.getForwardedTo().getUserId().equals(userId) || !request.getCurrentLevel().equals("PM")) {
                            continue;
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + role);
                }

                requestDTOS.add(RequestDTO.toRequestDTO(request, images));
            }
            return requestDTOS;
        }
        return List.of();
    }


    /**
     * Find all requests of CO
     * @param id - the ID of the CO
     * @return List of RequestDTOs
     */
    public List<RequestDTO> getAllRequestOfCO(Long id) {
        List<Request> requests = requestRepository.findRequestsByUserUserId(id);
        if (requests != null) {
            List<RequestDTO> listOfRequestDtos = new ArrayList<>();
            for (Request request : requests) {

                // Find All Images for the request
                List<Image> images = imageService.getImagesByRequest(request);
                if (images == null) {
                    images = new ArrayList<>();
                }

                // Add the request to the list
                listOfRequestDtos.add(RequestDTO.toRequestDTO(request, images));
            }
            return listOfRequestDtos;
        }
        return List.of();
    }


    /**
     * Delete a request by ID if it exists
     * @param id - the ID of the request to delete
     * @return true if the request was deleted, false otherwise
     */
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
     * Find a request by ID
     * @param id - the ID of the request
     * @return The request if it exists
     */
    public Optional<Request> findRequestById(Long id) {
        return requestRepository.findById(id);
    }

    /**
     * Convert a RequestDTO to a Request entity
     * @param requestDTO - The RequestDTO to convert
     * @param user - The User who created the request
     * @param site - The Site associated with the request
     * @param forwardTo - The User to whom the request is forwarded
     * @return - The converted Request entity
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
     * Set the roles for the request entity
     * @param request - The request entity
     * @param requestDTO - The request DTO
     */
    private static void setRoles (Request request, RequestDTO requestDTO) {
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
