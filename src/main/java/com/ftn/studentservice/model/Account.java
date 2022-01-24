package com.ftn.studentservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy="account")
    private List<Payment> payments;

    @Column(nullable = false)
    private String accountNumber;

}
