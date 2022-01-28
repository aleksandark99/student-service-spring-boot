package com.ftn.studentservice.controller;

import com.ftn.student_service.api.model.CourseResponse;
import com.ftn.student_service.api.spec.v1.CourseApi;
import com.ftn.studentservice.model.Course;
import com.ftn.studentservice.service.CourseService;
import com.ftn.studentservice.utills.ObjectMapperUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import static com.ftn.studentservice.controller.Headers.enrichWithPagingHeaders;
import static org.springframework.http.ResponseEntity.*;

import java.util.List;

@Controller
public class CourseController implements CourseApi {

    private ObjectMapperUtils mapper;

    @Autowired
    private CourseService courseService;

    @Override
    public ResponseEntity<List<CourseResponse>> getCourses(Integer page, Integer size) {
        Page<Course> courses = courseService.getCourses(page, size);
        return enrichWithPagingHeaders(ok(),courses)
                .body(mapper.mapAll(courses.toList(),CourseResponse.class));
    }
}
