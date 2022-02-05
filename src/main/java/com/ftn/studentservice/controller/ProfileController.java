package com.ftn.studentservice.controller;

import com.ftn.studentservice.dto.response.ProfileChangeDto;
import com.ftn.studentservice.dto.response.ProfileDto;
import com.ftn.studentservice.repository.StudentRepository;
import com.ftn.studentservice.repository.UserRepository;
import com.ftn.studentservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/{userType}/{userId}")
    public ResponseEntity<ProfileDto> getProfileInfo(@PathVariable("userType") String userType,
                                                     @PathVariable("userId") Long userId){

        return ResponseEntity.ok().body(profileService.getProfileInfo(userType, userId));

    }

    @PostMapping("/updateEmail/{userId}/{newEmail}")
    private ResponseEntity<ProfileChangeDto> updateEmail(@PathVariable("userId") Long userId,
                                                         @PathVariable("newEmail") String newEmail){

        return ResponseEntity.ok().body(ProfileChangeDto.builder().successfully(profileService.updateEmail(newEmail, userId)).build());
    }

}
