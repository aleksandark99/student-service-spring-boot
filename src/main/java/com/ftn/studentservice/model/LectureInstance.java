package com.ftn.studentservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class LectureInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_instance")
    private CourseInstance courseInstance;

    @ManyToMany
    private List<Lecturer> lecturers;
}
