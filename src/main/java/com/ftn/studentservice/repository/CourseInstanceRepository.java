package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Integer> {
}
