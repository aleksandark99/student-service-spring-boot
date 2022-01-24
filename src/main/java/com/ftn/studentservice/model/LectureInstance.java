package com.ftn.studentservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class LectureInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_instance")
    private CourseInstance courseInstance;

    @ManyToMany(mappedBy = "lectureInstances")
    private List<Lecturer> lecturers;
}
