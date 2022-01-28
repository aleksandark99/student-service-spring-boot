package com.ftn.studentservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private  Enrollment enrollment;
//
//    private String title;
//
//    private LocalDateTime date;
//
//    private boolean graded;
//
//    private boolean attending;
//
//    private int points;
}
