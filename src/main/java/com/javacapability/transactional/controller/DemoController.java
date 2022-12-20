package com.javacapability.transactional.controller;

import com.javacapability.transactional.dto.StudentDTO;
import com.javacapability.transactional.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/students")
    public ResponseEntity<String> createStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
        return ResponseEntity.ok("Data inserted");
    }
}
