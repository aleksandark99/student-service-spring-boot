package com.ftn.studentservice.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String objectName;

    @Column(name = "mime_type", unique = false, nullable = true)
    private String mimeType;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;
}
