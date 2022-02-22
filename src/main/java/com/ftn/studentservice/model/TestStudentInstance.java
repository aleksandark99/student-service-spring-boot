package com.ftn.studentservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class TestStudentInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int points;

    @Column
    private boolean isGraded;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToOne
    private Student student;

    @Transient
    private String courseName;

    @Transient
    private String date;

    public String getDate(){
        return test.getDate().toString();
    }

    public String getCourseName(){
        return test.getCourseInstance().getCourse().getName();
    }
}
