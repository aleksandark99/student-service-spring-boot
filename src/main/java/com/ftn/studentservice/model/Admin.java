package com.ftn.studentservice.model;

import javax.persistence.*;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;


}
