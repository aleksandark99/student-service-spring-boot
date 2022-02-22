package com.ftn.studentservice.service;

import com.ftn.studentservice.model.*;
import com.ftn.studentservice.repository.ExamPeriodRepository;
import com.ftn.studentservice.repository.TestRepository;
import com.ftn.studentservice.repository.TestStudentInstanceRepository;
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

    @Autowired
    private TestStudentInstanceRepository testStudentInstanceRepository;

    public List<ExamPeriod> getActiveExamPeriods() {
        return examPeriodRepository.findAllValid();
    }

    public List<Test> getTests(Long examPeriodId) {
        Student stuent = studentService.getLoggedInStudent();

        var testsRegisteredFor = testStudentInstanceRepository.findAll().stream().filter(testStudentInstance ->
                testStudentInstance.getStudent().getId().equals(stuent.getId()))
                .map(testStudentInstance -> testStudentInstance.getTest().getId()).collect(Collectors.toList());

        return examPeriodRepository.findById(examPeriodId).get().getTests().stream()
                .filter(test -> !testsRegisteredFor.contains(test.getId())).collect(Collectors.toList());
    }

    public List<Long> getIdsOfTestsStudentRegisteredFor() {
        Student stuent = studentService.getLoggedInStudent();
        Stream<CourseInstance> courseInstances = stuent.getEnrollments().stream().map(Enrollment::getCourseInstance);
        return courseInstances.flatMap(courseInstance -> courseInstance.getTests().stream().map(Test::getId))
                .collect(Collectors.toList());
    }

    ;

}
