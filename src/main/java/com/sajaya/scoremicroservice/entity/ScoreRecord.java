package com.sajaya.scoremicroservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scores", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"subject_id", "student_id"})
})
public class ScoreRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private long recordId;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "score")
    @Min(value = 0, message = "The score should be between 0 and 20")
    @Max(value = 20, message = "The score should be between 0 and 20")
    private Double score;

    public void update(ScoreRecord updatedRecord) {
        this.subject = updatedRecord.getSubject();
        this.student = updatedRecord.getStudent();
        this.score = updatedRecord.getScore();
    }
}
