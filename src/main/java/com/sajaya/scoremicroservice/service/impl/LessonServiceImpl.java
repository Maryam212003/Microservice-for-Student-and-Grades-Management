package com.sajaya.scoremicroservice.service.impl;

import com.sajaya.scoremicroservice.dto.LessonDTO;
import com.sajaya.scoremicroservice.entity.Lesson;
import com.sajaya.scoremicroservice.exception.ResourceNotFoundException;
import com.sajaya.scoremicroservice.mapper.LessonMapper;
import com.sajaya.scoremicroservice.repository.LessonRepository;
import com.sajaya.scoremicroservice.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;

    @Override
    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Lesson lesson = LessonMapper.mapToLesson(lessonDTO);
        Lesson savedLesson = lessonRepository.save(lesson);
        return LessonMapper.mapToLessonDTO(savedLesson);
    }

    @Override
    public LessonDTO getLessonById(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).
                orElseThrow(() -> new ResourceNotFoundException("There is not lesson with given id " + lessonId));
        return LessonMapper.mapToLessonDTO(lesson);
    }

    @Override
    public List<LessonDTO> getAllStudents() {
        return null;
    }

    @Override
    public LessonDTO updateLesson(Long lessonId, LessonDTO updatedLessonDTO) {
        return null;
    }

    @Override
    public void deleteStudent(Long studentId) {

    }
}
