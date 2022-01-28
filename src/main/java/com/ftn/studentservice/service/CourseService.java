package com.ftn.studentservice.service;

import com.ftn.studentservice.model.Course;
import com.ftn.studentservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Page<Course> getCourses(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return courseRepository.findAll(pageable);
    }
}
