package com.ftn.studentservice.service;

import com.ftn.studentservice.dto.response.ProfileDto;
import com.ftn.studentservice.repository.LecturerRepository;
import com.ftn.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    public ProfileDto getProfileInfo(String userType, String userId){
        if (userType.equalsIgnoreCase("student")){
           // return studentRepository.findByUser_Id(Long.valueOf(userId));
        }

        if (userType.equalsIgnoreCase("student")){
           // return lecturerRepository.findByUser_Id(Long.valueOf(userId));
        }

        return null;
    }

}
