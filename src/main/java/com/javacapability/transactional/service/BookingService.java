package com.javacapability.transactional.service;

import com.javacapability.transactional.model.dto.PassengerBookingDTO;

public interface BookingService {

    void addBooking(PassengerBookingDTO passengerBookingDTO);

    void addBookingTransactional(PassengerBookingDTO passengerBookingDTO);
}
