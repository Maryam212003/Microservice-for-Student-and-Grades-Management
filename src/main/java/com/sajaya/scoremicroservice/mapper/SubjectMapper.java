package com.sajaya.scoremicroservice.mapper;

import com.sajaya.scoremicroservice.dto.SubjectDTO;
import com.sajaya.scoremicroservice.entity.Subject;

public class SubjectMapper {
    public static Subject mapToSubject(SubjectDTO subjectDTO) {
        return new Subject(
                subjectDTO.getGroupID(),
                subjectDTO.getSubjectName(),
                subjectDTO.getTeacherName()
        );
    }

    public static SubjectDTO mapToSubjectDTO(Subject subject) {
        return new SubjectDTO(
                subject.getGroupID(),
                subject.getSubjectName(),
                subject.getTeacherName()
        );
    }
}
