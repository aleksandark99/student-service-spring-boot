package com.ftn.studentservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "lecturer_code", unique = true)
    private String lecturerCode;

    @ManyToMany
    @JoinTable
    private List<LectureInstance> lectureInstances = new ArrayList<>();
}
