package com.sajaya.scoremicroservice.repository;

import com.sajaya.scoremicroservice.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
