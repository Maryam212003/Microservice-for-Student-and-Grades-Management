package com.sajaya.scoremicroservice.repository;

import com.sajaya.scoremicroservice.entity.ScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRecordRepository extends JpaRepository<ScoreRecord, Long> {
    @Query(value = "SELECT new com.sajaya.scoremicroservice.entity.ScoreRecord(r.recordId, r.subject, r.student, r.score) " +
            "FROM ScoreRecord r WHERE r.student.studentId = :studentId")
    List<ScoreRecord> findByStudentId(@Param("studentId") Long studentId);

    @Query(value = "SELECT new com.sajaya.scoremicroservice.entity.ScoreRecord(r.recordId, r.subject, r.student, r.score)" +
            "FROM ScoreRecord r WHERE r.subject.subjectId = :subjectId")
    List<ScoreRecord> findBySubjectId(@Param("subjectId") Long subjectId);

}
