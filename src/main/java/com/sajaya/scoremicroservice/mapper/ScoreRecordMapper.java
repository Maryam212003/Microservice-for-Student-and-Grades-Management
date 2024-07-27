package com.sajaya.scoremicroservice.mapper;


import com.sajaya.scoremicroservice.dto.ScoreRecordDTO;
import com.sajaya.scoremicroservice.entity.ScoreRecord;
import com.sajaya.scoremicroservice.entity.Student;
import com.sajaya.scoremicroservice.entity.Subject;

public class ScoreRecordMapper {

    public static ScoreRecord mapToScoreRecord(ScoreRecordDTO scoreRecordDTO, Student student, Subject subject) {
        return new ScoreRecord(
                scoreRecordDTO.getRecordId(),
                subject,
                student,
                scoreRecordDTO.getScore()
        );
    }

    public static ScoreRecordDTO mapToScoreRecordDTO(ScoreRecord scoreRecord) {
        return new ScoreRecordDTO(
                scoreRecord.getRecordId(),
                scoreRecord.getSubject().getSubjectId(),
                scoreRecord.getStudent().getStudentId(),
                scoreRecord.getScore()
        );
    }
}

