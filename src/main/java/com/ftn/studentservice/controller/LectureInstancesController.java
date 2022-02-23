package com.ftn.studentservice.controller;

import com.ftn.student_service.api.model.EnrollmentResponse;
import com.ftn.student_service.api.model.LectureInstanceResponse;
import com.ftn.student_service.api.spec.v1.EnrollmentApi;
import com.ftn.student_service.api.spec.v1.LectureInstancesApi;
import com.ftn.studentservice.model.Enrollment;
import com.ftn.studentservice.model.LectureInstance;
import com.ftn.studentservice.service.LecturerService;
import com.ftn.studentservice.service.StudentService;
import com.ftn.studentservice.utills.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LectureInstancesController implements LectureInstancesApi {

    @Autowired
    private LecturerService lecturerService;

    private ObjectMapperUtils mapper;



    @Override
    public ResponseEntity<List<LectureInstanceResponse>> getMyLectures() {
        List<LectureInstance> myEnrollments=lecturerService.getLoggedInLecturer().getLectureInstances();
        return ResponseEntity.ok(mapper.mapAll(myEnrollments,LectureInstanceResponse.class));
    }
}
