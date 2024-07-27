package com.sajaya.scoremicroservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @NotNull
    @Size(min = 2, message = "First Name should have at least 2 character")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, message = "First Name should have at least 2 character")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Size(min = 2, message = "First Name should have at least 2 character")
    @Column(name = "father_name")
    private String fatherName;

    @NotNull
    @Size (min = 8, max = 10, message = "The ID number size should be 8-10 number")
    @Column(name = "id_number", unique = true)
    private String idNumber;

    //date of birth

    public void update(Student updatedStudent) {
        this.firstName = updatedStudent.getFirstName();
        this.lastName = updatedStudent.getLastName();
        this.fatherName = updatedStudent.getFatherName();
        this.idNumber = updatedStudent.getIdNumber();
    }
}
