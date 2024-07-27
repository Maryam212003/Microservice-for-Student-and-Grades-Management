package com.sajaya.scoremicroservice.mapper;

import com.sajaya.scoremicroservice.dto.LessonDTO;
import com.sajaya.scoremicroservice.entity.Lesson;

public class LessonMapper {
    public static Lesson mapToLesson(LessonDTO lessonDTO) {
        return new Lesson(
                lessonDTO.getLessonID(),
                lessonDTO.getGroupID(),
                lessonDTO.getLessonName(),
                lessonDTO.getTeacherName()
        );
    }

    public static LessonDTO mapToLessonDTO(Lesson lesson) {
        return new LessonDTO(
                lesson.getLessonID(),
                lesson.getGroupID(),
                lesson.getLessonName(),
                lesson.getTeacherName()
        );
    }
}
