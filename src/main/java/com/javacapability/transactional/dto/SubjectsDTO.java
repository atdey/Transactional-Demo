package com.javacapability.transactional.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class SubjectsDTO {

    private Long id;
    @JsonIgnore
    private StudentDTO student;
    private String name;
    private String category;
}
