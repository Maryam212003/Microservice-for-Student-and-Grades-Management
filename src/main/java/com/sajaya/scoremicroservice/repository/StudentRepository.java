package com.sajaya.scoremicroservice.repository;

import com.sajaya.scoremicroservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // You can define custom query methods here if needed???
}
