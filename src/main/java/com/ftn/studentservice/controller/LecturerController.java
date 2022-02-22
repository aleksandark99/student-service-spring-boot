package com.ftn.studentservice.controller;

import com.ftn.studentservice.dto.request.SearchLecturerDto;
import com.ftn.studentservice.dto.request.SearchStudentDto;
import com.ftn.studentservice.dto.response.LecturerDto;
import com.ftn.studentservice.dto.response.StudentDto;
import com.ftn.studentservice.model.Lecturer;
import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.service.LecturerService;
import com.ftn.studentservice.service.StudentService;
import com.ftn.studentservice.utills.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.ftn.studentservice.controller.Headers.enrichWithPagingHeaders;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    private ObjectMapperUtils mapper;

    @PostMapping("/{courseInstanceId}")
    public ResponseEntity<List<LecturerDto>> searchLecturer(@PathVariable("courseInstanceId") Integer courseInstanceId,
                                                            @RequestBody SearchLecturerDto searchLecturerDto) {

        Page<Lecturer> lecturers = lecturerService.getLecturer(courseInstanceId, searchLecturerDto);

        return enrichWithPagingHeaders(ok(), lecturers)
                .body(lecturers.toList().stream().map(lecturer -> LecturerDto.builder()
                        .firstName(lecturer.getUser().getFirstName())
                        .lastName(lecturer.getUser().getLastName())
                        .id(lecturer.getUser().getId()).code(lecturer.getLecturerCode()).build()).collect(Collectors.toList()));
    }


    @GetMapping("/not-in-course/{courseInstanceId}")
    public ResponseEntity<List<LecturerDto>> getLecturersNotInCourseInstance(@PathVariable("courseInstanceId") Long courseInstanceId) {
        return ResponseEntity.ok(lecturerService.getLecturersNotInCourseInstance(courseInstanceId).stream()
                .map(lecturer -> LecturerDto.builder()
                        .firstName(lecturer.getUser().getFirstName())
                        .lastName(lecturer.getUser().getLastName())
                        .id(lecturer.getUser().getId()).code(lecturer.getLecturerCode()).build()).collect(Collectors.toList()));
    }


    @PutMapping("/{lecturerId}/{courseInstanceId}")
    public ResponseEntity<String> addLecturerToCourse(@PathVariable("lecturerId") Long lecturerId,
                                                    @PathVariable("courseInstanceId") Long courseInstanceId){
        try{
            lecturerService.addLecturerToCourse(lecturerId,courseInstanceId);
            return ResponseEntity.ok().body("Lecturer add to course");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

