package com.sajaya.scoremicroservice.controller;

import com.sajaya.scoremicroservice.dto.LessonDTO;
import com.sajaya.scoremicroservice.dto.StudentDTO;
import com.sajaya.scoremicroservice.entity.Lesson;
import com.sajaya.scoremicroservice.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonDTO> createLesson(@RequestBody LessonDTO lessonDTO) {
        LessonDTO savedLesson = lessonService.createLesson(lessonDTO);
        return new ResponseEntity<>(savedLesson, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<LessonDTO> getLessonById(@PathVariable("id") Long lessonId) {
        LessonDTO foundLesson = lessonService.getLessonById(lessonId);
        return ResponseEntity.ok(foundLesson);
    }

    @GetMapping
    public ResponseEntity<List<LessonDTO>> getAllLessons() {
        List<LessonDTO> lessons = lessonService.getAllStudents();
        return ResponseEntity.ok(lessons);
    }

    @PutMapping("{id}")
    public ResponseEntity<LessonDTO> updateLesson (@PathVariable("id") Long lessonId,
                                                   @RequestBody LessonDTO updatedLessonDTO) {
        LessonDTO lessonDTO = lessonService.updateLesson(lessonId, updatedLessonDTO);
        return ResponseEntity.ok(lessonDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLesson(@PathVariable("id") Long lessonId) {
        lessonService.deleteLesson(lessonId);
        return ResponseEntity.ok("Successfully deleted!");
    }

}

