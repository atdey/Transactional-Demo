package com.javacapability.transactional.service;

import com.javacapability.transactional.entity.PassengerBooking;
import com.javacapability.transactional.entity.PassengerDetails;
import com.javacapability.transactional.entity.RailwayBankDetails;
import com.javacapability.transactional.model.dto.PassengerBookingDTO;
import com.javacapability.transactional.model.dto.PassengerDetailsDTO;
import com.javacapability.transactional.model.request.BookingRequest;
import com.javacapability.transactional.repository.PassengerBookingRepository;
import com.javacapability.transactional.repository.PassengerDetailsRepository;
import com.javacapability.transactional.repository.RailwayBankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private PassengerBookingRepository passengerBookingRepository;

    @Autowired
    private PassengerDetailsRepository passengerDetailsRepository;

    @Autowired
    private RailwayBankRepository railwayBankRepository;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void addBooking(PassengerBookingDTO passengerBookingDTO) {
        add(passengerBookingDTO);
    }

    @Transactional
    @Override
    public void addBookingDeclarativeTransactional(PassengerBookingDTO passengerBookingDTO) {
        add(passengerBookingDTO);
    }

    @Override
    public void addBookingProgrammaticTransactional(PassengerBookingDTO passengerBookingDTO) {
        this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            public void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    add(passengerBookingDTO);
                } catch(RuntimeException ex) {
                    status.setRollbackOnly();
                    throw new RuntimeException(ex.getMessage());
                }
            }
        });
    }

    private void add(PassengerBookingDTO passengerBookingDTO) {
        ModelMapper mapper = new ModelMapper();
        Optional<PassengerDetails> passengerDetails = passengerDetailsRepository
                .findById(passengerBookingDTO.getPassengerId());
        Optional<RailwayBankDetails> railwayDetails = railwayBankRepository
                .findById(passengerBookingDTO.getPassengerId());
        if (passengerDetails.isPresent() && railwayDetails.isPresent()) {
            paymentService.validatePayment(passengerDetails.get().getBalance(), passengerBookingDTO.getFare());
            PassengerBooking passengerBooking = new PassengerBooking();
            mapper.map(passengerBookingDTO, passengerBooking);
            passengerBookingRepository.save(passengerBooking);

            paymentService.validatePassengerBankServer();

            PassengerDetails passenger = passengerDetails.get();
            passenger.setBalance(passenger.getBalance() - passengerBookingDTO.getFare());
            passengerDetailsRepository.save(passenger);

            paymentService.validateRailwayBankServer();

            RailwayBankDetails bankDetails = railwayDetails.get();
            bankDetails.setBalance(bankDetails.getBalance() + passengerBookingDTO.getFare());
            railwayBankRepository.save(bankDetails);
        }
    }
}
