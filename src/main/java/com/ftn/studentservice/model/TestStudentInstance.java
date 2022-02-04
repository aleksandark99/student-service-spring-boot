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
}
