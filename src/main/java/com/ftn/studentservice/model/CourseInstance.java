package com.ftn.studentservice.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "courseInstance")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "courseInstance")
    private List<LectureInstance> lectureInstances;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
