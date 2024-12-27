package com.example.itsmbackend.repository;

import com.example.itsmbackend.entity.Request;
import com.example.itsmbackend.entity.Spare;
import com.example.itsmbackend.entity.SparesRequest;
import com.example.itsmbackend.entity.User;
import com.example.itsmbackend.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SparesRequestsRepository extends JpaRepository<SparesRequest, Long> {

     Optional<SparesRequest> findByRequest(Request request);
     Optional<List<SparesRequest> > findByCurrentLevel(Role role);
     Optional<List<SparesRequest> >  findAllByNextAssignee(User user);
}
