package com.javacapability.transactional.service;

import com.javacapability.transactional.entity.PassengerDetails;
import com.javacapability.transactional.entity.RailwayBankDetails;
import com.javacapability.transactional.model.dto.PassengerDetailsDTO;
import com.javacapability.transactional.repository.PassengerDetailsRepository;
import com.javacapability.transactional.repository.RailwayBankRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RailBankServiceImpl implements RailBankService {

    @Autowired
    private RailwayBankRepository railwayBankRepository;

    @Override
    public PassengerDetailsDTO getRailBankDtoByName(String name) {
        Optional<RailwayBankDetails> railwayBankDetailsOptional = railwayBankRepository.findByName(name);
        ModelMapper mapper = new ModelMapper();
        PassengerDetailsDTO passengerDetailsDTO = new PassengerDetailsDTO();
        if (railwayBankDetailsOptional.isPresent()) {
            mapper.map(railwayBankDetailsOptional.get(), passengerDetailsDTO);
        }
        return passengerDetailsDTO;
    }
}
