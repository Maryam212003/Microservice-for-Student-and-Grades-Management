package com.sajaya.scoremicroservice.controller;

import com.sajaya.scoremicroservice.dto.StudentDTO;
import com.sajaya.scoremicroservice.entity.Student;
import com.sajaya.scoremicroservice.service.StudentService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> studentDTOS = studentService.getAllStudents();
        return ResponseEntity.ok(studentDTOS);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDTO> updateStudent (@PathVariable("id") Long studentId,
                                                     @RequestBody StudentDTO updatedStudent) {
        StudentDTO studentDTO = studentService.updateStudent(studentId, updatedStudent);
        return ResponseEntity.ok(studentDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Successfully deleted!");
    }
}
