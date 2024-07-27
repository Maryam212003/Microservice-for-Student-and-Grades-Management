package com.sajaya.scoremicroservice.entity;

import com.sajaya.scoremicroservice.enumclasses.LessonGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonID;

    @NotNull

    @Column(name = "lesson_group")
    @Enumerated(EnumType.STRING)
    private LessonGroup groupID;

    @NotNull
    @Column(name = "lesson_name")
    private String lessonName;

    @NotNull
    @Column(name = "teacher_name")
    private String teacherName;

}
