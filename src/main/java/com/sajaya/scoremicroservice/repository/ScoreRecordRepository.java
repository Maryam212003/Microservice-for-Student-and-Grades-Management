package com.sajaya.scoremicroservice.repository;

import com.sajaya.scoremicroservice.entity.ScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRecordRepository extends JpaRepository<ScoreRecord, Long> {
    List<ScoreRecord> findByStudentId(Long studentId);
    List<ScoreRecord> findBySubjectId(Long subjectId);
}
