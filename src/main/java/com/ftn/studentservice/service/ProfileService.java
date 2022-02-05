package com.ftn.studentservice.service;

import com.ftn.studentservice.dto.response.ProfileDto;
import com.ftn.studentservice.model.Lecturer;
import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.model.User;
import com.ftn.studentservice.repository.LecturerRepository;
import com.ftn.studentservice.repository.StudentRepository;
import com.ftn.studentservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private UserRepository userRepository;

    public ProfileDto getProfileInfo(String userType, Long userId){
        if (userType.equalsIgnoreCase("student")){
            Student student = studentRepository.findByUser_Id(userId);
            if (student == null){
                return ProfileDto.builder().unknownUser(true).build();
            }else {
                return ProfileDto.builder().unknownUser(false).firstName(student.getUser().getFirstName())
                        .lastName(student.getUser().getLastName())
                        .email(student.getUser().getEmail())
                        .indexOrCode(student.getIndex()).build();
            }
        }

        if (userType.equalsIgnoreCase("lecturer")){
            Lecturer lecturer = lecturerRepository.findByUser_Id(userId);
            if (lecturer == null){
                return ProfileDto.builder().unknownUser(true).build();
            }else {
                return ProfileDto.builder().unknownUser(false).firstName(lecturer.getUser().getFirstName())
                        .lastName(lecturer.getUser().getLastName())
                        .email(lecturer.getUser().getEmail())
                        .indexOrCode(lecturer.getLecturerCode()).build();
            }
        }

        return ProfileDto.builder().unknownUser(true).build();

    }

    public String updateEmail(String newEmail, Long userId){

        Optional<User> byEmail = userRepository.findByEmail(newEmail);
        if (byEmail.isPresent() && byEmail.get().getId() != userId) {
            return "With this email there is already an existing user.";
        }

        User byId = userRepository.getById(userId);
        byId.setEmail(newEmail);
        userRepository.save(byId);

        return "Successfully changed email!";


    }
}
