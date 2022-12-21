package com.javacapability.transactional.service;

import com.javacapability.transactional.model.dto.PassengerDetailsDTO;

public interface PassengerDetailsService {

    PassengerDetailsDTO getPassengerDetailsDtoByName(String name);
}
