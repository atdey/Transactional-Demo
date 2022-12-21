package com.javacapability.transactional.repository;

import com.javacapability.transactional.entity.PassengerDetails;
import com.javacapability.transactional.model.dto.PassengerDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Long> {

    Optional<PassengerDetails> findByName(String name);
}
