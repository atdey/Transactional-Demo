package com.javacapability.transactional.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacapability.transactional.entity.PassengerDetails;
import com.javacapability.transactional.model.dto.PassengerDetailsDTO;
import com.javacapability.transactional.repository.PassengerDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerDetailsServiceImpl implements PassengerDetailsService {

    @Autowired
    private PassengerDetailsRepository passengerDetailsRepository;

    @Override
    public PassengerDetailsDTO getPassengerDetailsDtoByName(String name) {
        Optional<PassengerDetails> passengerDetailsOptional = passengerDetailsRepository.findByName(name);
        ModelMapper mapper = new ModelMapper();
        PassengerDetailsDTO passengerDetailsDTO = new PassengerDetailsDTO();
        if (passengerDetailsOptional.isPresent()) {
            mapper.map(passengerDetailsOptional.get(), passengerDetailsDTO);
        }
        return passengerDetailsDTO;
    }
}
