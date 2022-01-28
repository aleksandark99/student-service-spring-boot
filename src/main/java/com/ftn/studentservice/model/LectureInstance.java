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
}
