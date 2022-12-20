package com.javacapability.transactional.service;

import com.javacapability.transactional.dto.StudentDTO;
import com.javacapability.transactional.entity.Student;
import com.javacapability.transactional.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        studentRepository.findAll();
        return studentRepository.findAll().stream().map(student -> {
            StudentDTO studentDTO = new StudentDTO();
            mapper.map(student, studentDTO);
            return studentDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        ModelMapper mapper = new ModelMapper();
        Student student = new Student();
        mapper.map(studentDTO, student);
        studentRepository.save(student);
    }
}
