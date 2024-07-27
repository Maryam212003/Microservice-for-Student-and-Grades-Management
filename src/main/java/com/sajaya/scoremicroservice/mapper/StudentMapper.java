package com.sajaya.scoremicroservice.mapper;

import com.sajaya.scoremicroservice.dto.StudentDTO;
import com.sajaya.scoremicroservice.entity.Student;

public class StudentMapper {
    public static Student mapToStudent(StudentDTO studentDTO) {
        return new Student(
                studentDTO.getStudentID(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getFatherName(),
                studentDTO.getIdNumber()
        );
    }

    public static StudentDTO mapToStudentDTO(Student student) {
        return new StudentDTO(
                student.getStudentId(),
                student.getFirstName(),
                student.getLastName(),
                student.getFatherName(),
                student.getIdNumber()
        );
    }
}
