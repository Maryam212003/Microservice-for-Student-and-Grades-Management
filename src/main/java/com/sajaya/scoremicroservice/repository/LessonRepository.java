package com.sajaya.scoremicroservice.repository;

import com.sajaya.scoremicroservice.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
