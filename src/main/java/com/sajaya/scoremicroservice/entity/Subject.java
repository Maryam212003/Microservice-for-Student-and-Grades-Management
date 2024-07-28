package com.sajaya.scoremicroservice.entity;

import com.sajaya.scoremicroservice.enumclasses.SubjectGroup;
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
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;

    @NotNull
    @Column(name = "subject_group")
    @Enumerated(EnumType.STRING)
    private SubjectGroup groupID;

    @NotNull
    @Column(name = "subject_name")
    private String subjectName;

    @NotNull
    @Column(name = "teacher_name")
    private String teacherName;

    public Subject(SubjectGroup groupID, String subjectName, String teacherName) {
        this.groupID = groupID;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
    }

    public void update(Subject updatedSubject) {
        this.groupID = updatedSubject.getGroupID();
        this.subjectName = updatedSubject.getSubjectName();
        this.teacherName = updatedSubject.getTeacherName();
    }
}
