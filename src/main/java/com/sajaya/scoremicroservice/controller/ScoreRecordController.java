package com.sajaya.scoremicroservice.controller;

import com.sajaya.scoremicroservice.dto.ScoreRecordDTO;
import com.sajaya.scoremicroservice.dto.StudentDTO;
import com.sajaya.scoremicroservice.dto.SubjectDTO;
import com.sajaya.scoremicroservice.entity.ScoreRecord;
import com.sajaya.scoremicroservice.mapper.ScoreRecordMapper;
import com.sajaya.scoremicroservice.service.ScoreRecordService;
import com.sajaya.scoremicroservice.service.impl.ScoreRecordServiceImp;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/records")
public class ScoreRecordController {

    private ScoreRecordService recordService;

    @PostMapping
    public ResponseEntity<ScoreRecordDTO> addRecord(@Valid @RequestBody ScoreRecordDTO scoreRecordDTO) {
        ScoreRecordDTO savedRecord = recordService.addRecord(scoreRecordDTO);
        return new ResponseEntity<>(savedRecord, HttpStatus.CREATED);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<ScoreRecordDTO>> getRecordByStudentId(@PathVariable("id") Long studentId) {
        List<ScoreRecordDTO> records = recordService.getRecordByStudentId(studentId);
        return ResponseEntity.ok(records);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<List<ScoreRecordDTO>> getRecordBySubjectId(@PathVariable("id") Long subjectId) {
        List<ScoreRecordDTO> records = recordService.getRecordBySubjectId(subjectId);
        return ResponseEntity.ok(records);
    }

    @GetMapping
    public ResponseEntity<List<ScoreRecordDTO>> getAllRecords() {
        List<ScoreRecordDTO> records = recordService.getAllRecords();
        return ResponseEntity.ok(records);
    }

    @PutMapping("{id}")
    public ResponseEntity<ScoreRecordDTO> updateScoreRecord(@PathVariable("id") Long recordId,
                                                            @RequestBody ScoreRecordDTO updatedRecordDTO) {
        ScoreRecordDTO record = recordService.updateScoreRecord(recordId, updatedRecordDTO);
        return ResponseEntity.ok(record);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteRecord(@PathVariable("id") Long recordId) {
        recordService.deleteRecord(recordId);
        return ResponseEntity.ok("Successfully deleted!");
    }
    @GetMapping("/student/{id}/average")
    public Double getStudentAverage(@PathVariable("id") Long studentId) {
        return recordService.calcStudentAverage(studentId);
    }
}
