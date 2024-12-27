package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.Request;
import com.example.itsmbackend.entity.Spare;
import com.example.itsmbackend.entity.SparesRequest;
import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.RequestType;
import com.example.itsmbackend.entity.enums.Role;
import com.example.itsmbackend.entity.enums.SparesRequestStatus;
import com.example.itsmbackend.payloads.SpareDTO;
import com.example.itsmbackend.payloads.SparesRequestDTO;
import com.example.itsmbackend.repository.RequestRepository;
import com.example.itsmbackend.repository.SparesRequestsRepository;
import com.example.itsmbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SparesRequestService {

    private final SparesRequestsRepository sparesRequestsRepository;
    private final RequestRepository requestRepository;
    private  final UserRepository userRepository;

    public SparesRequestService(UserRepository userRepository,SparesRequestsRepository sparesRequestsRepository, RequestRepository requestRepository) {
        this.sparesRequestsRepository = sparesRequestsRepository;
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    /**
     * Creates a new SparesRequest linked to an existing Request and includes spare items.
     *
     * @param requestId       The ID of the Request for which the SparesRequest is being created.
     * @param requestedSpares A list of SpareDTO objects representing the spare items being requested.
     * @return A SparesRequestDTO object representing the created SparesRequest.
     * @throws EntityNotFoundException If the Request with the specified ID does not exist.
     * @throws IllegalArgumentException If the Request type is not SPARE.
     */
    public SparesRequestDTO createSparesRequest(Long requestId, List<SpareDTO> requestedSpares , String username ) {
        User createdBy = userRepository.findByEmail(username);
        if (createdBy == null){
            throw  new EntityNotFoundException("User Not Found");
        }

        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new EntityNotFoundException("Request with ID " + requestId + " not found"));

        validateSpareRequestType(request);

        SparesRequest sparesRequest = SparesRequest.builder()
                .request(request)
                .status(SparesRequestStatus.CREATED)
                .currentLevel(Role.TGL)
                .createdBy(createdBy)
                .nextAssignee(createdBy.getSupervisor())
                .isClosed(false)
                .build();

        List<Spare> spares = new ArrayList<>();
        requestedSpares.forEach(spareDTO -> {
            Spare spare = toSpare(spareDTO);
            spare.setSparesRequest(sparesRequest);
            spares.add(spare);
        });
        sparesRequest.setSpares(spares);

        SparesRequest savedRequest = sparesRequestsRepository.save(sparesRequest);
        return SparesRequestDTO.toSparesRequestDTO(savedRequest);
    }

    /**
     * Retrieves a SparesRequest associated with a specific Request ID.
     *
     * @param requestId The ID of the Request for which the SparesRequest is being retrieved.
     * @return A SparesRequestDTO object representing the retrieved SparesRequest.
     * @throws EntityNotFoundException If the Request with the specified ID does not exist.
     * @throws EntityNotFoundException If the SparesRequest associated with the Request does not exist.
     * @throws IllegalArgumentException If the Request type is not SPARE.
     */
    public SparesRequestDTO getSparesRequest(Long requestId) {
        Request request = requestRepository.findById(requestId)
                .orElseThrow(() -> new EntityNotFoundException("Request with ID " + requestId + " not found"));

        validateSpareRequestType(request);

        SparesRequest sparesRequest = sparesRequestsRepository.findByRequest(request)
                .orElseThrow(() -> new EntityNotFoundException("Spares Request not found for Request ID " + requestId));

        return SparesRequestDTO.toSparesRequestDTO(sparesRequest);
    }


    /**
     * Retrieve spare requests assined to current user
     */
    public  List<SparesRequestDTO> getSparesRequestForUser(String username){
        User currentUser = userRepository.findByEmail(username);
        if (currentUser == null){
            throw new EntityNotFoundException("User not found");
        }

        List<SparesRequest> sparesRequests =  sparesRequestsRepository.findAllByNextAssignee(currentUser)
                .orElseThrow( () -> new EntityNotFoundException("No Request found"));

        return sparesRequests.stream().map(SparesRequestDTO::toSparesRequestDTO).collect(Collectors.toList());
    }

    /**
     * Update spare request
     */
    public SparesRequestDTO updateSparesRequest(Long spareRequestId , SparesRequestDTO sparesRequest, String username){
        User currentUser = userRepository.findByEmail(username);
        if (currentUser == null){
            throw  new EntityNotFoundException("User not found");
        }

        SparesRequest originalSparesRequest = sparesRequestsRepository.findById(spareRequestId).orElseThrow(() -> new EntityNotFoundException("Spare request not found"));

        // Validating the user
        if (!currentUser.equals(originalSparesRequest.getNextAssignee())){
            throw new IllegalStateException("You are not authorized to update this request");
        }

        // Update remarks if provided
    if (sparesRequest.getRemarks() != null) {
        sparesRequest.setRemarks(sparesRequest.getRemarks());
    }

    // Process status updates and assign the next user
    switch (currentUser.getRole()) {
        case TGL:
            if (sparesRequest.getStatus() == SparesRequestStatus.VERIFIED_BY_TGL) {
                originalSparesRequest.setStatus(SparesRequestStatus.VERIFIED_BY_TGL);
                originalSparesRequest.setCurrentLevel(Role.RM);
                originalSparesRequest.setVerifiedByTGL(currentUser); // Track TGL action
                originalSparesRequest.setNextAssignee(currentUser.getSupervisor()); // Assign RM
            } else if (sparesRequest.getStatus() == SparesRequestStatus.REJECTED_BY_TGL) {
                originalSparesRequest.setStatus(SparesRequestStatus.REJECTED_BY_TGL);
                originalSparesRequest.setClosed(true);
                originalSparesRequest.setNextAssignee(null); // No next action
            } else {
                throw new IllegalArgumentException("Invalid action for TGL");
            }
            break;

        case RM:
            if (sparesRequest.getStatus() == SparesRequestStatus.APPROVED_BY_RM) {
                originalSparesRequest.setStatus(SparesRequestStatus.APPROVED_BY_RM);
                originalSparesRequest.setCurrentLevel(Role.MC);
                originalSparesRequest.setApprovedByRM(currentUser); // Track RM action
                originalSparesRequest.setNextAssignee(userRepository.findFirstByRole(Role.MC));
            } else if (sparesRequest.getStatus() == SparesRequestStatus.REJECTED_BY_RM) {
                originalSparesRequest.setStatus(SparesRequestStatus.REJECTED_BY_RM);
                originalSparesRequest.setClosed(true);
                originalSparesRequest.setNextAssignee(null); // No next action
            } else {
                throw new IllegalArgumentException("Invalid action for RM");
            }
            break;

        case MC:
            if (sparesRequest.getStatus() == SparesRequestStatus.CLOSED) {
                originalSparesRequest.setStatus(SparesRequestStatus.CLOSED);
                originalSparesRequest.setVerifiedByMC(currentUser); // Track MC action
                originalSparesRequest.setClosed(true);
                originalSparesRequest.setNextAssignee(null); // No next action
            } else {
                throw new IllegalArgumentException("Invalid action for MC");
            }
            break;

        default:
            throw new IllegalStateException("Invalid role for update");
    }

    // Save and return updated SparesRequest
    SparesRequest updatedRequest = sparesRequestsRepository.save(originalSparesRequest);
    return SparesRequestDTO.toSparesRequestDTO(updatedRequest);
    }

    /**
     * Validates that the provided Request is of type SPARE.
     *
     * @param request The Request object to validate.
     * @throws IllegalArgumentException If the Request type is not SPARE.
     */
    private void validateSpareRequestType(Request request) {
        if (!request.getType().equals(RequestType.SPARE)) {
            throw new IllegalArgumentException("Cannot create or retrieve Spare Request for a non-SPARE request type. " +
                    "Request ID: " + request.getId());
        }
    }

    /**
     * Converts a SpareDTO object to a Spare entity.
     *
     * @param spareDTO The SpareDTO object to convert.
     * @return A Spare entity containing the same data as the SpareDTO.
     */
    private static Spare toSpare(SpareDTO spareDTO) {
        return Spare.builder()
                .itemCode(spareDTO.getItemCode())
                .itemName(spareDTO.getItemName())
                .unit(spareDTO.getUnit())
                .quantity(spareDTO.getQuantity())
                .approvedQuantity(spareDTO.getApprovedQuantity())
                .build();
    }
}
