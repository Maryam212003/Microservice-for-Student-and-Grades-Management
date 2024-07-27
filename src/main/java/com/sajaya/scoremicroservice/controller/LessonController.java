package com.sajaya.scoremicroservice.controller;

import com.sajaya.scoremicroservice.dto.LessonDTO;
import com.sajaya.scoremicroservice.dto.StudentDTO;
import com.sajaya.scoremicroservice.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}

