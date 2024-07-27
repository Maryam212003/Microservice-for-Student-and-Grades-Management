package com.sajaya.scoremicroservice.controller;

import com.sajaya.scoremicroservice.dto.SubjectDTO;
import com.sajaya.scoremicroservice.entity.Subject;
import com.sajaya.scoremicroservice.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO subjectDTO) {
        SubjectDTO savedSubject = subjectService.createSubject(subjectDTO);
        return new ResponseEntity<>(savedSubject, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable("id") Long subjectId) {
        SubjectDTO foundSubject = subjectService.getSubjectById(subjectId);
        return ResponseEntity.ok(foundSubject);
    }

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
        List<SubjectDTO> subjects = subjectService.getAllStudents();
        return ResponseEntity.ok(subjects);
    }

    @PutMapping("{id}")
    public ResponseEntity<SubjectDTO> updateSubject (@PathVariable("id") Long subjectId,
                                                   @RequestBody SubjectDTO updatedSubjectDTO) {
        SubjectDTO subjectDTO = subjectService.updateSubject(subjectId, updatedSubjectDTO);
        return ResponseEntity.ok(subjectDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok("Successfully deleted!");
    }

}

