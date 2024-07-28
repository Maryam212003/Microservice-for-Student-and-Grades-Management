package com.sajaya.scoremicroservice.mapper;


import com.sajaya.scoremicroservice.dto.ScoreRecordDTO;
import com.sajaya.scoremicroservice.entity.ScoreRecord;
import com.sajaya.scoremicroservice.entity.Student;
import com.sajaya.scoremicroservice.entity.Subject;

public class ScoreRecordMapper {

    public static ScoreRecord mapToScoreRecord(ScoreRecordDTO scoreRecordDTO,  Subject subject, Student student) {
        return new ScoreRecord(
                subject,
                student,
                scoreRecordDTO.getScore()
        );
    }

    public static ScoreRecordDTO mapToScoreRecordDTO(ScoreRecord scoreRecord) {
        return new ScoreRecordDTO(
                scoreRecord.getSubject().getSubjectId(),
                scoreRecord.getStudent().getStudentId(),
                scoreRecord.getScore()
        );
    }

}

