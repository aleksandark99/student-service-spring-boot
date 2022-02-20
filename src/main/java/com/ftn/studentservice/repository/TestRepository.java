package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Student, Long> {


}
