package com.javacapability.transactional.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDTO {

    private Long id;
    private String name;
    private String stream;
    private List<SubjectsDTO> subjects;
}

