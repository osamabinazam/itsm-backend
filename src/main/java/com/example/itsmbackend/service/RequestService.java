package com.example.itsmbackend.service;

import com.example.itsmbackend.entity.Request;
import com.example.itsmbackend.repository.RequestRepository;
import com.example.itsmbackend.repository.SiteRepository;
import com.example.itsmbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private SiteRepository siteRepository;

    @Autowired
    private UserRepository userRepository;
    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    public Request updateRequest( Request request ,long id) {
        Optional<Request> requestInDb = requestRepository.findById(id);
        if (requestInDb.isPresent()) {
            if (requestInDb.get().getStatus().equals("CLOSED")) {
                return null;
            }
            Request requestToUpdate = requestInDb.get();
            requestToUpdate.setFaultDescription(request.getFaultDescription() != null ? request.getFaultDescription() : requestToUpdate.getFaultDescription());
            requestToUpdate.setStatus(request.getStatus() != null ? request.getStatus() : requestToUpdate.getStatus());
//            requestToUpdate.setForwardToRM(request.getForwardToRM() != null ? request.getForwardToRM() : requestToUpdate.getForwardToRM());
            requestToUpdate.setType(request.getType() != null ? request.getType() : requestToUpdate.getType());
            return requestRepository.save(requestToUpdate);
        } else {
            return null;

        }
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
}
