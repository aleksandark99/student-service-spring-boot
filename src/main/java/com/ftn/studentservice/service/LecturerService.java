package com.ftn.studentservice.service;

import com.ftn.studentservice.dto.request.SearchLecturerDto;
import com.ftn.studentservice.dto.request.SearchStudentDto;
import com.ftn.studentservice.model.CourseInstance;
import com.ftn.studentservice.model.LectureInstance;
import com.ftn.studentservice.model.Lecturer;
import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.repository.CourseInstanceRepository;
import com.ftn.studentservice.repository.LectureInstanceRepository;
import com.ftn.studentservice.repository.LecturerRepository;
import com.ftn.studentservice.repository.StudentRepository;
import com.ftn.studentservice.service.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Autowired
    private LectureInstanceRepository lectureInstanceRepository;

    public Page<Lecturer> getLecturer(Integer courseInstanceId, SearchLecturerDto searchLecturerDto) {

        Pageable pageable = PageRequest.of(searchLecturerDto.getPageNo(), searchLecturerDto.getPageSize());

        if (courseInstanceId > -1){

            return lecturerRepository.findByLectureInstances_CourseInstance_Id(Long.valueOf(courseInstanceId), pageable);

        } else {

            return lecturerRepository.findAllByLecturerCodeContainsOrUser_FirstNameContainsOrUser_LastNameContains(searchLecturerDto.getSearchWord(),searchLecturerDto.getSearchWord(),searchLecturerDto.getSearchWord(),pageable);

        }


    }


    public List<Lecturer> getLecturersNotInCourseInstance(Long courseInstanceId) {
        return lecturerRepository.findAll().stream()
                .filter(lecturer ->
                        lecturer.getLectureInstances().stream().noneMatch(lectureInstance ->
                                lectureInstance.getCourseInstance().getId().equals(courseInstanceId))).collect(Collectors.toList());
    }

    public void addLecturerToCourse(Long lecturerId, Long courseInstanceId) throws CustomException {
        Lecturer lecturer = lecturerRepository.findById(lecturerId).orElseThrow(() -> new CustomException("lecturer not found"));

        CourseInstance courseInstance = courseInstanceRepository.findById(courseInstanceId)
                .orElseThrow(() -> new CustomException("Course instance not found"));

        LectureInstance lectureInstance = new LectureInstance();
        courseInstance.getLectureInstances().add(lectureInstance);
        lectureInstance.setCourseInstance(courseInstance);
        lectureInstance.getLecturers().add(lecturer);

        lectureInstanceRepository.save(lectureInstance);

    }
}
