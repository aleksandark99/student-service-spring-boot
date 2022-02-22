package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {


}
