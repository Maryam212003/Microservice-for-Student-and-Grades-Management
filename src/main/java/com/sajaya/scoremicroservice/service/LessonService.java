package com.sajaya.scoremicroservice.service;

import com.sajaya.scoremicroservice.dto.LessonDTO;
import com.sajaya.scoremicroservice.entity.Lesson;

import java.util.List;

public interface LessonService {
    LessonDTO createLesson(LessonDTO lessonDTO);
    LessonDTO getLessonById(Long lessonId);
    List<LessonDTO> getAllStudents();
    LessonDTO updateLesson(Long lessonId, LessonDTO updatedLessonDTO);
    void deleteStudent(Long studentId);
}
