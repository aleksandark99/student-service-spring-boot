package com.ftn.studentservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    private List<LectureInstance> lectureInstances;
}
