package com.ftn.studentservice.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class CourseInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "courseInstance")
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToMany(mappedBy = "courseInstance")
    private List<LectureInstance> lectureInstances = new ArrayList<>();

    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String name;

    @OneToMany(mappedBy = "courseInstance")
    private List<Test> tests = new ArrayList<>();

    public String getName(){
        return course.getName();
    }
}
