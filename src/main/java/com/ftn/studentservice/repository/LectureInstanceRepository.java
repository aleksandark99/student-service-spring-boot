package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.LectureInstance;
import com.ftn.studentservice.model.Lecturer;
import com.ftn.studentservice.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureInstanceRepository extends JpaRepository<LectureInstance, Long> {


}

