package com.ftn.studentservice.controller;

import com.ftn.student_service.api.model.CourseInstanceResponse;
import com.ftn.student_service.api.model.CourseResponse;
import com.ftn.student_service.api.spec.v1.CourseInstanceApi;
import com.ftn.studentservice.model.Course;
import com.ftn.studentservice.model.CourseInstance;
import com.ftn.studentservice.service.CourseInstanceService;
import com.ftn.studentservice.utills.ObjectMapperUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ftn.studentservice.controller.Headers.enrichWithPagingHeaders;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@Api(value = "CourseInstance")
public class CourseInstanceController implements CourseInstanceApi {

    private ObjectMapperUtils mapper;

    @Autowired
    private CourseInstanceService courseInstanceService;

    @Override
    public ResponseEntity<List<CourseInstanceResponse>> getCourseInstances(Integer page, Integer size, Integer courseId, String search) {
        Page<CourseInstance> courseInstances = courseInstanceService.getCourseInstances(courseId, page, size, search);
        return enrichWithPagingHeaders(ok(), courseInstances)
                .body(mapper.mapAll(courseInstances.toList(), CourseInstanceResponse.class));
    }


}
