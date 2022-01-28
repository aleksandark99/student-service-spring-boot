package com.ftn.studentservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int points;

    @ManyToOne
    @JoinColumn(name = "course_instance")
    private CourseInstance courseInstance;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;
}
