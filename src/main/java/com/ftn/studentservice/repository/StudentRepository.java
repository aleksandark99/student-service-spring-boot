package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public Page<Student> findByEnrollments_CourseInstance_Id(Long id, Pageable pageable);
    public Page<Student> findAllByIndexContainsOrUser_FirstNameContainsOrUser_LastNameContains(String index,String firstName,String lastName, Pageable pageable);
    Optional<Student> findByUser_Email(String email);
    public Student findByUser_Id(Long id);
}
