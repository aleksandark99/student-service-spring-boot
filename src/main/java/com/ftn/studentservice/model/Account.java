package com.ftn.studentservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy = "account")
    private List<Payment> payments = new ArrayList<>();

    @Column(nullable = false)
    private String accountNumber;

    @Column
    private Double balance;

}
