package com.sajaya.scoremicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ScoreRecordDTO {
    private Long subjectId;
    private Long studentId;
    private Double score;

}
