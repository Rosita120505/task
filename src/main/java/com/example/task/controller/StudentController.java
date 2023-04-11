package com.example.task.controller;

import com.example.task.model.dto.StudentDto;
import com.example.task.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentRepository.getAllStudents());


    }
}
