package com.ftn.studentservice.controller;

import com.ftn.student_service.api.model.EnrollmentResponse;
import com.ftn.student_service.api.spec.v1.EnrollmentApi;
import com.ftn.studentservice.model.Enrollment;
import com.ftn.studentservice.service.StudentService;
import com.ftn.studentservice.utills.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController implements EnrollmentApi {

    @Autowired
    private StudentService studentService;

    private ObjectMapperUtils mapper;


    @Override
    public ResponseEntity<List<EnrollmentResponse>> getMyEnrollments() {
        List<Enrollment> myEnrollments=studentService.getLoggedInStudent().getEnrollments();
        return ResponseEntity.ok(mapper.mapAll(myEnrollments,EnrollmentResponse.class));    }
}
