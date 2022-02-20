package com.ftn.studentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="course_instance_id")
    private  CourseInstance courseInstance;

    @JsonIgnore
    @OneToMany(mappedBy = "test")
    private List<TestStudentInstance> testStudentInstances = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="period_id", nullable=false)
    private ExamPeriod period;

    @Transient
    private String description;

    public String getDescription(){
        return this.courseInstance.getName() +" "+ this.title;
    }
}
