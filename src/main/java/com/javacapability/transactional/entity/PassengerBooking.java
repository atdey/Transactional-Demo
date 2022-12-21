package com.javacapability.transactional.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "passenger_booking")
public class PassengerBooking {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "passenger_seq")
    private Long id;

    @Column(name = "passenger_id")
    private Long passengerId;

    @Column(name = "rail_id")
    private Long railId;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "fare")
    private Double fare;
}

