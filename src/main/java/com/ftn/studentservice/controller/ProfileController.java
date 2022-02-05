package com.ftn.studentservice.controller;

import com.ftn.studentservice.repository.StudentRepository;
import com.ftn.studentservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userType}/{userId}")
    public Object getProfileInfo(@PathVariable("userType") String userType,
                                 @PathVariable("userId") String userId){




        return null;

    }

}
