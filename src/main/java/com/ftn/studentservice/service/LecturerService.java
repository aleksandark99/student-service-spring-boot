package com.ftn.studentservice.service;

import com.ftn.studentservice.dto.request.SearchLecturerDto;
import com.ftn.studentservice.dto.request.SearchStudentDto;
import com.ftn.studentservice.model.Lecturer;
import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.repository.LecturerRepository;
import com.ftn.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;


    public Page<Lecturer> getLecturer(Integer courseInstanceId, SearchLecturerDto searchLecturerDto) {

        Pageable pageable = PageRequest.of(searchLecturerDto.getPageNo(), searchLecturerDto.getPageSize());

        if (courseInstanceId > -1){

            return lecturerRepository.findByLectureInstances_CourseInstance_Id(Long.valueOf(courseInstanceId), pageable);

        } else {

            return lecturerRepository.findAllByLecturerCodeContainsOrUser_FirstNameContainsOrUser_LastNameContains(searchLecturerDto.getSearchWord(),searchLecturerDto.getSearchWord(),searchLecturerDto.getSearchWord(),pageable);

        }


    }


}
