package com.sajaya.scoremicroservice.service;

import com.sajaya.scoremicroservice.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Long studentId);
    List<StudentDTO> getAllStudents();
    StudentDTO updateStudent(Long studentId, StudentDTO updatedStudentDTO);

    void deleteStudent(Long studentId);

}
