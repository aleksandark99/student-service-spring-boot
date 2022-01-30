package com.ftn.studentservice.service;

import com.ftn.studentservice.dto.request.SearchStudentDto;
import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Page<Student> getStudent(Integer courseInstanceId, SearchStudentDto searchStudentDto) {

        Pageable pageable = PageRequest.of(searchStudentDto.getPageNo(), searchStudentDto.getPageSize());

        if (courseInstanceId != null){

            return studentRepository.findByEnrollments_CourseInstance_Id(Long.valueOf(courseInstanceId), pageable);

        } else {

            return studentRepository.findAllByIndexContainsOrUser_FirstNameContainsOrUser_LastNameContains(searchStudentDto.getSearchWord(),searchStudentDto.getSearchWord(),searchStudentDto.getSearchWord(),pageable);

        }


    }




}
