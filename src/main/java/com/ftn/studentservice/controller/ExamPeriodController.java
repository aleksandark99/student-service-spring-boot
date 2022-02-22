package com.ftn.studentservice.controller;

import com.ftn.studentservice.model.ExamPeriod;
import com.ftn.studentservice.model.Test;
import com.ftn.studentservice.service.ExamPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamPeriodController {

    @Autowired
    private ExamPeriodService examPeriodService;

    @GetMapping(value = "/exam-periods")
    public ResponseEntity<List<ExamPeriod>> getActiveExamPeriods(){
        return ResponseEntity.ok(examPeriodService.getActiveExamPeriods());
    }

    @GetMapping("/exam-periods/{id}/tests")
    public List<Test> getTestsForExamPeriodAndStudent(@PathVariable Long id){
        return examPeriodService.getTests(id);
    }

    @GetMapping("/exam-periods/{id}/ids-of-my-tests")
    public List<Long> getListOfMyTests(@PathVariable Long id){
        return examPeriodService.getIdsOfTestsStudentRegisteredFor();
    }
}
