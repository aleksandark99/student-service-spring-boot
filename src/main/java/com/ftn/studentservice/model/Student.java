package com.ftn.studentservice.model;

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
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy="student")
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToOne(mappedBy = "student")
    private Account account;

    @OneToMany(mappedBy="student")
    private List<Document> documents = new ArrayList<>();

    @Column(nullable = true)
    private String indeks;
}
