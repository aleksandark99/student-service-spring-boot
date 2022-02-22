package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.Document;
import com.ftn.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    List<Document> findByStudent(Student student);
}
