package com.ftn.studentservice.controller;

import com.ftn.student_service.api.model.CourseResponse;
import com.ftn.studentservice.dto.request.SearchStudentDto;
import com.ftn.studentservice.dto.response.StudentDto;
import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.repository.StudentRepository;
import com.ftn.studentservice.service.StudentService;
import com.ftn.studentservice.utills.ObjectMapperUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.ftn.studentservice.controller.Headers.enrichWithPagingHeaders;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private  StudentService studentService;

    private ObjectMapperUtils mapper;

    @PostMapping("/{courseInstanceId}")
    public ResponseEntity<List<StudentDto>> searchStudents(@PathVariable("courseInstanceId") Integer courseInstanceId,
                                                           @RequestBody SearchStudentDto searchStudentDto){

        Page<Student> students = studentService.getStudent(null, searchStudentDto);

        return enrichWithPagingHeaders(ok(), students)
                .body(students.toList().stream().map(student -> StudentDto.builder()
                        .firstName(student.getUser().getFirstName())
                        .lastName(student.getUser().getLastName())
                        .id(student.getId()).index(student.getIndex()).build()).collect(Collectors.toList()));
    }



}
