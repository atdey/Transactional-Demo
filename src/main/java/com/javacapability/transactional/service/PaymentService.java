package com.javacapability.transactional.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    @Value("${app.bank.server.running}")
    private boolean isBankServerRunning;

    @Value("${app.passenger.server.running}")
    private boolean isPassengerServerRunning;

    public boolean validatePayment(Double passengerBalance, Double fare) {
        if (passengerBalance.compareTo(fare)<0) {
            throw new RuntimeException("Insufficient Balance");
        }
        log.info("Payment Validated....");
        return true;
    }

    public boolean validatePassengerBankServer() {
        if (!isBankServerRunning) {
            throw new RuntimeException("Passenger's bank server is down");
        }

        log.info("Passenger's Bank server is running....");
        return true;
    }

    public boolean validateRailwayBankServer() {
        if (!isBankServerRunning) {
            throw new RuntimeException("Railway's Bank server is down");
        }

        log.info("Passenger's Bank server is running....");
        return true;
    }

}
