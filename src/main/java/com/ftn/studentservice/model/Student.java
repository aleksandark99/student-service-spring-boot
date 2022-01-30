package com.ftn.studentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(name = "index_", unique = false, nullable = true)
    private String index;

    @OneToMany(mappedBy="student")
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToOne(mappedBy = "student")
    private Account account;

    @OneToMany(mappedBy="student")
    private List<Document> documents = new ArrayList<>();


}
