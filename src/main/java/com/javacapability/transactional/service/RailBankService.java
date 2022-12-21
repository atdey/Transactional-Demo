package com.javacapability.transactional.service;

import com.javacapability.transactional.model.dto.PassengerDetailsDTO;

public interface RailBankService {

    PassengerDetailsDTO getRailBankDtoByName(String name);
}
