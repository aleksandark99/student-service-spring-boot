package com.ftn.studentservice.service;

import com.ftn.student_service.api.model.CourseCreateRequest;
import com.ftn.studentservice.model.Course;
import com.ftn.studentservice.repository.CourseRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.function.Predicate;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Page<Course> getCourses(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        return courseRepository.findByNameContainsOrCodeContains(search,search,pageable);
    }

    public void createCourse(CourseCreateRequest courseCreateRequest) {

        Course course = new Course();
        course.setName(courseCreateRequest.getName());
        course.setEcts(courseCreateRequest.getEcts());
        course.setCode(String.valueOf(System.currentTimeMillis()));
        courseRepository.save(course);

    }
}
