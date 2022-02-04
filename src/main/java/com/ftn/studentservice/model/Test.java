package com.ftn.studentservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime date;

    private int maxPoints;

    private String place;

    @OneToOne
    private  Enrollment enrollment;

    @OneToMany(mappedBy = "test")
    private List<TestStudentInstance> testStudentInstances = new ArrayList<>();
}
