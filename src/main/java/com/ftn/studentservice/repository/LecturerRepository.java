package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.Lecturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

   public Page<Lecturer> findByLectureInstances_CourseInstance_Id(Long id, Pageable pageable);
   public Page<Lecturer> findAllByLecturerCodeContainsOrUser_FirstNameContainsOrUser_LastNameContains(String index,String firstName,String lastName, Pageable pageable);
   public Lecturer findByUser_Id(Long id);




}
