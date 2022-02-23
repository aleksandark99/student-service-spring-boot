package com.ftn.studentservice.controller;

import com.ftn.studentservice.dto.request.SearchStudentDto;
import com.ftn.studentservice.dto.response.LecturerDto;
import com.ftn.studentservice.dto.response.StudentDto;
import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.service.StudentService;
import com.ftn.studentservice.utills.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    private StudentService studentService;

    private ObjectMapperUtils mapper;

    @PostMapping("/{courseInstanceId}")
    public ResponseEntity<List<StudentDto>> searchStudents(@PathVariable("courseInstanceId") Integer courseInstanceId,
                                                           @RequestBody SearchStudentDto searchStudentDto) {

        Page<Student> students = studentService.getStudent(courseInstanceId, searchStudentDto);

        return enrichWithPagingHeaders(ok(), students)
                .body(students.toList().stream().map(student -> StudentDto.builder()
                        .firstName(student.getUser().getFirstName())
                        .lastName(student.getUser().getLastName())
                        .id(student.getUser().getId()).index(student.getIndex()).build()).collect(Collectors.toList()));
    }


    @GetMapping("/not-in-course/{courseInstanceId}")
    public ResponseEntity<List<StudentDto>> getLecturersNotInCourseInstance(@PathVariable("courseInstanceId") Long courseInstanceId) {
        return ResponseEntity.ok(studentService.getStudentNotInCourseInstance(courseInstanceId).stream()
                .map(student -> StudentDto.builder()
                        .firstName(student.getUser().getFirstName())
                        .lastName(student.getUser().getLastName())
                        .id(student.getUser().getId())
                        .index(student.getIndex()).build()).collect(Collectors.toList()));
    }


    @PutMapping("/{studentId}/{courseInstanceId}")
    public ResponseEntity<String> addLecturerToCourse(@PathVariable("studentId") Long studentId,
                                                      @PathVariable("courseInstanceId") Long courseInstanceId) {
        try {
            studentService.addStudentToCourse(studentId, courseInstanceId);
            return ResponseEntity.ok().body("Lecturer add to course");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
