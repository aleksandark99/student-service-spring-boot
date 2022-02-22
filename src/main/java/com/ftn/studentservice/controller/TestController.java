package com.ftn.studentservice.controller;


import com.ftn.student_service.api.model.EnrollmentResponse;
import com.ftn.student_service.api.model.TestInstance;
import com.ftn.student_service.api.model.TestInstanceRequest;
import com.ftn.student_service.api.spec.v1.TestApi;
import com.ftn.studentservice.model.Enrollment;
import com.ftn.studentservice.model.TestStudentInstance;
import com.ftn.studentservice.service.StudentService;
import com.ftn.studentservice.service.TestService;
import com.ftn.studentservice.service.exceptions.CustomException;
import com.ftn.studentservice.service.exceptions.InvalidBalanceException;
import com.ftn.studentservice.utills.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController implements TestApi {

    @Autowired
    private TestService testService;

    private ObjectMapperUtils mapper;

    @Autowired
    private StudentService studentService;

    @Override
    public ResponseEntity<String> createTest(TestInstanceRequest testInstanceRequest) {
        try {
            testService.createTest(testInstanceRequest);
            return ResponseEntity.status(201).build();
        } catch (CustomException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<TestInstance>> getMyTests() {
        List<TestStudentInstance> myTests = testService.getMyTests();
        return ResponseEntity.ok(mapper.mapAll(myTests, TestInstance.class));
    }

    @Override
    public ResponseEntity<String> gradeTest(Long testInstanceId, Integer points) {
        try {
            testService.gradeTest(testInstanceId,points);
            return ResponseEntity.status(201).build();
        } catch (CustomException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }    }

    @Override
    public ResponseEntity<String> registerForTest(Long testId) {
        try {
            testService.registerForTest(testId);
            return ResponseEntity.status(201).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }


}
