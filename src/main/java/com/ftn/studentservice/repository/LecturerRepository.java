package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.Lecturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

   // public Page<Student> findByEnrollments_CourseInstance_Id(Long id, Pageable pageable);
   public Page<Lecturer> findByLectureInstances_CourseInstance_Id(Long id, Pageable pageable);
    //public Page<Lecturer> findAllByCodeContainsOrUser_FirstNameContainsOrUser_LastNameContains(String index,String firstName,String lastName, Pageable pageable);
}
