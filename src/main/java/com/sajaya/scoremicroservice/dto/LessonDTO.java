package com.sajaya.scoremicroservice.dto;

import com.sajaya.scoremicroservice.enumclasses.LessonGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {
    private Long lessonID;
    private LessonGroup groupID;
    private String lessonName;
    private String teacherName;
}
