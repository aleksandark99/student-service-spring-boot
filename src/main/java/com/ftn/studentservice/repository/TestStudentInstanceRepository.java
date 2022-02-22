package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.TestStudentInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestStudentInstanceRepository extends JpaRepository<TestStudentInstance, Long> {

    List<TestStudentInstance> findAllByStudent_Id(Long studentId);
}
