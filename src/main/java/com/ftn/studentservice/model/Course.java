package com.ftn.studentservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int ects;

    @OneToMany(mappedBy = "course")
    private List<CourseInstance> courseInstances;

}
