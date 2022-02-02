package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findAllByIndeksContainsOrUser_FirstNameContainsOrUser_LastNameContains(String ind,String s,String s1, Pageable pageable);
}
