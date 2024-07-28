package com.sajaya.scoremicroservice.service.impl;

import com.sajaya.scoremicroservice.dto.ScoreRecordDTO;
import com.sajaya.scoremicroservice.entity.ScoreRecord;
import com.sajaya.scoremicroservice.exception.ResourceNotFoundException;
import com.sajaya.scoremicroservice.mapper.ScoreRecordMapper;
import com.sajaya.scoremicroservice.mapper.StudentMapper;
import com.sajaya.scoremicroservice.mapper.SubjectMapper;
import com.sajaya.scoremicroservice.repository.ScoreRecordRepository;
import com.sajaya.scoremicroservice.service.ScoreRecordService;
import com.sajaya.scoremicroservice.service.StudentService;
import com.sajaya.scoremicroservice.service.SubjectService;
import jdk.jfr.consumer.RecordedMethod;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScoreRecordServiceImp implements ScoreRecordService {

    private ScoreRecordRepository recordRepository;
    private SubjectService subjectService;
    private StudentService studentService;

    @Override
    public ScoreRecordDTO addRecord(ScoreRecordDTO scoreRecordDTO) {
        ScoreRecord scoreRecord = ScoreRecordMapper.mapToScoreRecord(
                scoreRecordDTO,
                SubjectMapper.mapToSubject(subjectService.getSubjectById(scoreRecordDTO.getSubjectId())),
                StudentMapper.mapToStudent(studentService.getStudentById(scoreRecordDTO.getStudentId())));

        ScoreRecord savedRecord = recordRepository.save(scoreRecord);
        return ScoreRecordMapper.mapToScoreRecordDTO(savedRecord);
    }

    @Override
    public List<ScoreRecordDTO> getRecordByStudentId(Long studentId) {
        List<ScoreRecord> records = recordRepository.findByStudentId(studentId);
        return records.stream().map(ScoreRecordMapper::mapToScoreRecordDTO).collect(Collectors.toList());
    }

    @Override
    public List<ScoreRecordDTO> getRecordBySubjectId(Long subjectId) {
        List<ScoreRecord> records = recordRepository.findBySubjectId(subjectId);
        return records.stream().map(ScoreRecordMapper::mapToScoreRecordDTO).collect(Collectors.toList());
    }

    @Override
    public List<ScoreRecordDTO> getAllRecords() {
        List<ScoreRecord> records = recordRepository.findAll();
        return records.stream().map(ScoreRecordMapper::mapToScoreRecordDTO).collect(Collectors.toList());
    }

    @Override
    public ScoreRecordDTO updateScoreRecord(Long recordId, ScoreRecordDTO updatedRecordDTO) {
        ScoreRecord scoreRecord = recordRepository.findById(recordId).
                orElseThrow(() -> new ResourceNotFoundException("There is not any record with given id " + recordId));
        ScoreRecord updatedRecord  = ScoreRecordMapper.mapToScoreRecord(
                updatedRecordDTO,
                SubjectMapper.mapToSubject(subjectService.getSubjectById(updatedRecordDTO.getSubjectId())),
                StudentMapper.mapToStudent(studentService.getStudentById(updatedRecordDTO.getStudentId())));

        scoreRecord.update(updatedRecord);

        ScoreRecord updatedRecordObj = recordRepository.save(scoreRecord);

        return ScoreRecordMapper.mapToScoreRecordDTO(updatedRecordObj);
    }

    @Override
    public ScoreRecordDTO updateStudentScore(Long subjectId, Long studentId, Double updatedScore) {
        return null;
    }

    @Override
    public void deleteRecord(Long recordId) {
        recordRepository.deleteById(recordId);
    }

    @Override
    public void deleteStudentRecords(Long studentId) {

    }

    @Override
    public void deleteSubjectRecords(Long subjectId) {

    }
}
