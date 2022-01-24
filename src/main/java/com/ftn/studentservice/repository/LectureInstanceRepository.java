package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.LectureInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureInstanceRepository extends JpaRepository<LectureInstance, Integer> {
}
