package com.sajaya.scoremicroservice.service;

import com.sajaya.scoremicroservice.dto.SubjectDTO;
import com.sajaya.scoremicroservice.entity.Subject;

import java.util.List;

public interface SubjectService {
    SubjectDTO createSubject(SubjectDTO subjectDTO);
    SubjectDTO getSubjectById(Long subjectId);
    List<SubjectDTO> getAllStudents();
    SubjectDTO updateSubject(Long subjectId, SubjectDTO updatedSubjectDTO);
    void deleteSubject(Long subjectId);
}
