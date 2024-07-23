package com.sajaya.scoremicroservice.service;

import com.sajaya.scoremicroservice.dto.StudentDTO;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDTO);
    StudentDTO getStudentById(Long studentId);
}
