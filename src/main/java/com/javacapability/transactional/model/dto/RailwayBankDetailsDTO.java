package com.javacapability.transactional.model.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class RailwayBankDetailsDTO {

    private Long id;
    private String name;
    private String accountNo;
    private Double balance;
}
