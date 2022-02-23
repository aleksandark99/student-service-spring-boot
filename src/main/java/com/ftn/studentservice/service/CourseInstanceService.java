package com.ftn.studentservice.service;

import com.ftn.studentservice.dto.request.CreateCourseInstanceDto;
import com.ftn.studentservice.dto.response.CourseInstanceCreationResponseDto;
import com.ftn.studentservice.model.Course;
import com.ftn.studentservice.model.CourseInstance;
import com.ftn.studentservice.model.Test;
import com.ftn.studentservice.repository.CourseInstanceRepository;
import com.ftn.studentservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

@Service
public class CourseInstanceService {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;


    @Autowired
    private CourseRepository courseRepository;

    public Page<CourseInstance> getCourseInstances(Integer courseId, Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (courseId != null)
            return courseInstanceRepository.findAllByCourseId(Long.valueOf(courseId), pageable);
        else
            return courseInstanceRepository.findByCourse_NameContains(search, pageable);
    }

    public CourseInstanceCreationResponseDto createCourseInstance(CreateCourseInstanceDto createCourseInstanceDto){

        LocalDate startDate =
                Instant.ofEpochMilli(Long.parseLong(createCourseInstanceDto.getStartDate()))
                        .atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate endDate =
                Instant.ofEpochMilli(Long.parseLong(createCourseInstanceDto.getEndDate()))
                        .atZone(ZoneId.systemDefault()).toLocalDate();

        Course course = courseRepository.getById(Long.valueOf(createCourseInstanceDto.getCourseId()));

        if (course == null) return CourseInstanceCreationResponseDto.builder()
                .reason("Unable to find Course.")
                .successful(false).courseInstanceId(-1L).build();

        List<CourseInstance> courseInstances = courseInstanceRepository.findAll();


        final boolean overlaps = courseInstances.stream().anyMatch(courseInstance -> Objects.equals(courseInstance.getName(), course.getName())
                );

        if (overlaps) return CourseInstanceCreationResponseDto.builder().successful(false)
                .reason("There is already another course instance for selected Course which is overlapping with an instance you are trying to create.")
                .courseInstanceId(-1L).build();

        CourseInstance newCourseInstance = new CourseInstance();
        newCourseInstance.setCourse(course);
        newCourseInstance.setStartDate(startDate);
        newCourseInstance.setEndDate(endDate);
        newCourseInstance.setName(course.getName());

        final CourseInstance saved = courseInstanceRepository.save(newCourseInstance);

        return CourseInstanceCreationResponseDto.builder().courseInstanceId(saved.getId()).successful(true).build();
    }

    public List<Test> getTestsForCourseInstancec(Long courseInstanceId) {
        return courseInstanceRepository.findById(courseInstanceId).get().getTests();
    }

/*    private boolean overlap(LocalDate mS, LocalDate mE, LocalDate nS, LocalDate nE){
//&& overlap(startDate, endDate, courseInstance.getStartDate(), courseInstance.getEndDate())
        return ! (mS.isAfter(nS) & mS.isAfter(nE) && mE.isAfter(nS) && mE.isAfter(nE));



    }*/
}
