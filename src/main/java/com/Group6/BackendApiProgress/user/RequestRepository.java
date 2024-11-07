package com.Group6.BackendApiProgress.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    // Custom query to find all active (Pending) requests
    List<Request> findByStatus(String status);
}
