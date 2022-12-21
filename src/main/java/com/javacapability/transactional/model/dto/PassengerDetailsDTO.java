package com.javacapability.transactional.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PassengerDetailsDTO {

    private Long id;
    private String name;
    private String accountNo;
    private Double balance;
    private List<PassengerBookingDTO> passengerBookings;
}

