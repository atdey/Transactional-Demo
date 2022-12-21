package com.javacapability.transactional.repository;

import com.javacapability.transactional.entity.PassengerBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerBookingRepository extends JpaRepository<PassengerBooking, Long> {
}
