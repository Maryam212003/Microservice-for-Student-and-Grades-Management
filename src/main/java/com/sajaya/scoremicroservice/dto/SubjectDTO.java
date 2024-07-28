package com.sajaya.scoremicroservice.dto;

import com.sajaya.scoremicroservice.enumclasses.SubjectGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private SubjectGroup groupID;
    private String subjectName;
    private String teacherName;
}
