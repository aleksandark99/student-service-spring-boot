package com.ftn.studentservice.model;

import javax.persistence.*;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int points;

    @ManyToOne
    @JoinColumn(name = "course_instance")
    private CourseInstance courseInstance;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;
}
