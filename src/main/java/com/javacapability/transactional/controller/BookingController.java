package com.javacapability.transactional.controller;

import com.javacapability.transactional.model.dto.PassengerBookingDTO;
import com.javacapability.transactional.model.dto.PassengerDetailsDTO;
import com.javacapability.transactional.model.request.BookingRequest;
import com.javacapability.transactional.repository.RailwayBankRepository;
import com.javacapability.transactional.service.BookingService;
import com.javacapability.transactional.service.BookingServiceImpl;
import com.javacapability.transactional.service.PassengerDetailsService;
import com.javacapability.transactional.service.RailBankService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PassengerDetailsService passengerDetailsService;

    @Autowired
    private RailBankService railBankService;

    @PostMapping("/booking")
    public ResponseEntity<String> createBooking(@RequestBody PassengerBookingDTO bookingRequest) {
        bookingService.addBooking(bookingRequest);
        return ResponseEntity.ok("Data inserted");
    }

    @PostMapping("/booking/{type}")
    public ResponseEntity<String> createBookingTransactional(
            @PathVariable("type") String transactionType, @RequestBody PassengerBookingDTO bookingRequest) {
        if (StringUtils.equals(transactionType, "programmatic")) {
            bookingService.addBookingProgrammaticTransactional(bookingRequest);
        } else {
            bookingService.addBookingDeclarativeTransactional(bookingRequest);
        }
        return ResponseEntity.ok("Data inserted");
    }

    @GetMapping("/passenger")
    public ResponseEntity<PassengerDetailsDTO> getBookingByName(@RequestParam String name) {
        return ResponseEntity.ok(passengerDetailsService.getPassengerDetailsDtoByName(name));
    }

    @GetMapping("/rail")
    public ResponseEntity<PassengerDetailsDTO> getRailByName(@RequestParam String name) {
        return ResponseEntity.ok(railBankService.getRailBankDtoByName(name));
    }
}
