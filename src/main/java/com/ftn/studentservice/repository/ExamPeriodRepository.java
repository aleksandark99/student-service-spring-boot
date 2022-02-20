package com.ftn.studentservice.repository;

import com.ftn.studentservice.model.ExamPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long> {

    @Query("SELECT e FROM ExamPeriod e WHERE e.endDate > CURRENT_DATE and e.startDate < CURRENT_DATE")
    List<ExamPeriod> findAllValid();
}
