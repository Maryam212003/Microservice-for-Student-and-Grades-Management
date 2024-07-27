package com.sajaya.scoremicroservice.service.impl;

import com.sajaya.scoremicroservice.dto.SubjectDTO;
import com.sajaya.scoremicroservice.entity.Subject;
import com.sajaya.scoremicroservice.exception.ResourceNotFoundException;
import com.sajaya.scoremicroservice.mapper.SubjectMapper;
import com.sajaya.scoremicroservice.repository.SubjectRepository;
import com.sajaya.scoremicroservice.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        Subject subject = SubjectMapper.mapToSubject(subjectDTO);
        Subject savedSubject = subjectRepository.save(subject);
        return SubjectMapper.mapToSubjectDTO(savedSubject);
    }

    @Override
    public SubjectDTO getSubjectById(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).
                orElseThrow(() -> new ResourceNotFoundException("There is not subject with given id " + subjectId));
        return SubjectMapper.mapToSubjectDTO(subject);
    }

    @Override
    public List<SubjectDTO> getAllStudents() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map((subject -> SubjectMapper.mapToSubjectDTO(subject))).collect(Collectors.toList());
    }

    @Override
    public SubjectDTO updateSubject(Long subjectId, SubjectDTO updatedSubjectDTO) {
        Subject subject = subjectRepository.findById(subjectId).
                orElseThrow(() -> new ResourceNotFoundException("There is not subject with given id " + subjectId));
        Subject updatedSubject = SubjectMapper.mapToSubject(updatedSubjectDTO);
        subject.update(updatedSubject);
        Subject updatedSubjectObj = subjectRepository.save(subject);
        return SubjectMapper.mapToSubjectDTO(updatedSubjectObj);
    }

    @Override
    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
