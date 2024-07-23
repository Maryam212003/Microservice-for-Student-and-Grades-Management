package com.sajaya.scoremicroservice.service.impl;

import com.sajaya.scoremicroservice.dto.StudentDTO;
import com.sajaya.scoremicroservice.entity.Student;
import com.sajaya.scoremicroservice.exception.ResourceNotFoundException;
import com.sajaya.scoremicroservice.mapper.StudentMapper;
import com.sajaya.scoremicroservice.repository.StudentRepository;
import com.sajaya.scoremicroservice.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.mapToStudent(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDTO(savedStudent);
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("There is not student with given id " + studentId));
        return StudentMapper.mapToStudentDTO(student);
    }
}
