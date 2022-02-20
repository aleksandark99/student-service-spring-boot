package com.ftn.studentservice.service;

import com.ftn.studentservice.model.*;
import com.ftn.studentservice.repository.ExamPeriodRepository;
import com.ftn.studentservice.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExamPeriodService {

    @Autowired
    private ExamPeriodRepository examPeriodRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private StudentService studentService;

    public List<ExamPeriod> getActiveExamPeriods() {
        return examPeriodRepository.findAllValid();
    }

    public List<Test> getTests(Long id) {
        return examPeriodRepository.findById(id).get().getTests();
    }

    public List<Long> getIdsOfTestsStudentRegisteredFor(Long id) {
        Student stuent = studentService.getLoggedInStudent();
        Stream<CourseInstance> courseInstances = stuent.getEnrollments().stream().map(Enrollment::getCourseInstance);
        return courseInstances.flatMap(courseInstance -> courseInstance.getTests().stream().map(Test::getId))
                .collect(Collectors.toList());
    }

    ;
//    public List<Test> getTests(Long id) {
//        Student stuent = studentService.getLoggedInStudent();
//        return examPeriodRepository.findById(id).get().getTests().stream().filter(test ->
//                        stuent.getEnrollments().stream().map(Enrollment::getCourseInstance)
//                                .anyMatch(courseInstance -> courseInstance.equals(test.getCourseInstance())))
//                .collect(Collectors.toList());
//
//
//    }
}
