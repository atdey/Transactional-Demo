package com.javacapability.transactional.repository;

import com.javacapability.transactional.entity.RailwayBankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RailwayBankRepository extends JpaRepository<RailwayBankDetails, Long> {

    Optional<RailwayBankDetails> findByName(String name);
}
