package com.ftn.studentservice.service;

import com.ftn.studentservice.model.CourseInstance;
import com.ftn.studentservice.repository.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    public Page<CourseInstance> getCourseInstances(Integer courseId, Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (courseId != null)
            return courseInstanceRepository.findAllByCourseId(Long.valueOf(courseId), pageable);
        else
            return courseInstanceRepository.findByCourse_NameContains(search, pageable);
    }
}
