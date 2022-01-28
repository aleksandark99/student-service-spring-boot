package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.CourseInstance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {

    Page<CourseInstance> findAllByCourseId(Long courseId, Pageable pageable);
}
