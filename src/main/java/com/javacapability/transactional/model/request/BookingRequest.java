package com.javacapability.transactional.model.request;

import com.javacapability.transactional.model.dto.PassengerBookingDTO;
import lombok.Data;

@Data
public class BookingRequest {
    private PassengerBookingDTO passengerBookingDTO;
}
