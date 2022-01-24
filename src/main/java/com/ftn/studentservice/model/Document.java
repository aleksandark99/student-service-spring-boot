package com.ftn.studentservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;
}
