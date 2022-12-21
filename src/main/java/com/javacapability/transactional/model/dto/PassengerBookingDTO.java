package com.javacapability.transactional.model.dto;

import lombok.Data;

@Data
public class PassengerBookingDTO {

    private Long id;
    private Long passengerId;
    private Long railId;
    private String source;
    private String destination;
    private Double fare;
}
