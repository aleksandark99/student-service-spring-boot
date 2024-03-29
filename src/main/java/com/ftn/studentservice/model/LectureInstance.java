package com.ftn.studentservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class LectureInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_instance")
    private CourseInstance courseInstance;

    @ManyToMany(mappedBy = "lectureInstances")
    private List<Lecturer> lecturers = new ArrayList<>();

    @Transient
    private String courseName;

    @Transient
    private Long courseInstanceId;

    @Transient
    private String courseDescription;

    public String getCourseName() {
        return courseInstance.getName();
    }

    public String getCourseDescription() {
        return courseInstance.getDescription();
    }

    public Long getCourseInstanceId() {
        return courseInstance.getId();
    }
}
