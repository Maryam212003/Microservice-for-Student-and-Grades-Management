package com.sajaya.scoremicroservice.service;

import com.sajaya.scoremicroservice.dto.ScoreRecordDTO;

import java.util.List;

public interface ScoreRecordService {
    ScoreRecordDTO addRecord(ScoreRecordDTO scoreRecordDTO);
    List<ScoreRecordDTO> getRecordByStudentId(Long studentId);
    List<ScoreRecordDTO> getRecordBySubjectId(Long subjectId);
    List<ScoreRecordDTO> getAllRecords();
    ScoreRecordDTO updateScoreRecord(Long recordId, ScoreRecordDTO updatedRecordDTO);
    ScoreRecordDTO updateStudentScore(Long subjectId, Long studentId, Double updatedScore);
    void deleteRecord(Long recordId);
    void deleteStudentRecords(Long studentId);
    void deleteSubjectRecords(Long subjectId);
}
