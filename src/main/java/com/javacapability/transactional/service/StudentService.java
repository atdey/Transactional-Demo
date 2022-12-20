package com.javacapability.transactional.service;

import com.javacapability.transactional.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();

    void addStudent(StudentDTO studentDTO);
}
