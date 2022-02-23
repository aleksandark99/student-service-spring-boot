package com.ftn.studentservice.service;

import com.ftn.studentservice.dto.request.SearchStudentDto;
import com.ftn.studentservice.model.*;
import com.ftn.studentservice.repository.CourseInstanceRepository;
import com.ftn.studentservice.repository.EnrollmentRepository;
import com.ftn.studentservice.repository.StudentRepository;
import com.ftn.studentservice.service.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Page<Student> getStudent(Integer courseInstanceId, SearchStudentDto searchStudentDto) {

        Pageable pageable = PageRequest.of(searchStudentDto.getPageNo(), searchStudentDto.getPageSize());

        if (courseInstanceId > -1) {

            return studentRepository.findByEnrollments_CourseInstance_Id(Long.valueOf(courseInstanceId), pageable);

        } else {

            return studentRepository.findAllByIndexContainsOrUser_FirstNameContainsOrUser_LastNameContains(searchStudentDto.getSearchWord(), searchStudentDto.getSearchWord(), searchStudentDto.getSearchWord(), pageable);

        }


    }

    public Student getLoggedInStudent() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Student student = studentRepository.findByUser_Email(auth.getName()).orElseThrow();
        return student;
    }

    public List<Student> getStudentNotInCourseInstance(Long courseInstanceId) {
        return studentRepository.findAll().stream()
                .filter(lecturer ->
                        lecturer.getEnrollments().stream().noneMatch(enrollment ->
                                enrollment.getCourseInstance().getId().equals(courseInstanceId))).collect(Collectors.toList());
    }

    public void addStudentToCourse(Long lecturerId, Long courseInstanceId) throws CustomException {
        Student student = studentRepository.findById(lecturerId).orElseThrow(() -> new CustomException("Student not found"));

        CourseInstance courseInstance = courseInstanceRepository.findById(courseInstanceId)
                .orElseThrow(() -> new CustomException("Course instance not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setPoints(0);
        enrollment.setPassed(false);
        enrollment.setCourseInstance(courseInstance);
        enrollment.setStudent(student);
        var en = enrollmentRepository.save(enrollment);
        student.getEnrollments().add(en);
        studentRepository.save(student);
    }
}
