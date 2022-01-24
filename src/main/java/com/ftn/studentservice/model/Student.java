package com.ftn.studentservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy="student")
    private List<Enrollment> enrollments;

    @OneToOne(mappedBy = "student")
    private Account account;

    @OneToMany(mappedBy="student")
    private List<Document> documents;
}
