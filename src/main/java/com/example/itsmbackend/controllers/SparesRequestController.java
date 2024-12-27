package com.example.itsmbackend.controllers;

import com.example.itsmbackend.payloads.SpareDTO;
import com.example.itsmbackend.payloads.SparesRequestDTO;
import com.example.itsmbackend.service.SparesRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spares-request")
public class SparesRequestController {

    private final SparesRequestService sparesRequestService;

    public SparesRequestController(SparesRequestService sparesRequestService){
        this.sparesRequestService =sparesRequestService;
    }

    @GetMapping
    public ResponseEntity<?> getSpareRequestOfCurrentUser(Authentication authentication){
        String username = authentication.getName();
        List<SparesRequestDTO> response= sparesRequestService.getSparesRequestForUser(username);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    @PostMapping("/{requestId}")
    public ResponseEntity<?> create(@PathVariable Long requestId, @RequestBody List<SpareDTO> requestedSpares, Authentication authentication){
        try{

            String username = authentication.getName();
            SparesRequestDTO sparesRequest = sparesRequestService.createSparesRequest(requestId, requestedSpares, username);
            return  new ResponseEntity<>(sparesRequest, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<?> getSpareRequestByRequestId(@PathVariable Long requestId){
        try{
            SparesRequestDTO sparesRequest = sparesRequestService.getSparesRequest(requestId);
            return  new ResponseEntity<>(sparesRequest, HttpStatus.OK);

        }catch (Exception e){
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSparesRequest(
            @PathVariable Long id,
            @RequestBody SparesRequestDTO sparesRequestDTO,
            Authentication authentication

    ){
         String username = authentication.getName();
         SparesRequestDTO updatedRequest = sparesRequestService.updateSparesRequest(id, sparesRequestDTO, username);

         return  new ResponseEntity<>(updatedRequest, HttpStatus.OK);
    }


}
