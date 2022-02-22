package com.ftn.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@AllArgsConstructor
public class Document {

    public Document() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "url", unique = false, nullable = true, columnDefinition = "varchar(500)")
    private String url;

    @Column(nullable = true)
    private String objectName;

    @Column(name = "mime_type", unique = false, nullable = true)
    private String mimeType;

    @Column(name = "created_at")
    private String createdAt;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;
}
