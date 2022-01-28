package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.LectureInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureInstanceRepository extends JpaRepository<LectureInstance, Integer> {
}
