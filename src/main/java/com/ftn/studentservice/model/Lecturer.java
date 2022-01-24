package com.ftn.studentservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    @JoinTable
    private List<LectureInstance> lectureInstances;
}
