package com.sajaya.scoremicroservice.controller;

import com.sajaya.scoremicroservice.dto.StudentDTO;
import com.sajaya.scoremicroservice.entity.Student;
import com.sajaya.scoremicroservice.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent (@RequestBody StudentDTO studentDTO) {
        StudentDTO savedStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") Long studentId) {
        StudentDTO foundStudent = studentService.getStudentById(studentId);
        return ResponseEntity.ok(foundStudent);
    }
}
