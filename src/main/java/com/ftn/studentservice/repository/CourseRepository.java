package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Page<Course> findByNameContainsOrCodeContains(String name,String code,Pageable pageable);
}
