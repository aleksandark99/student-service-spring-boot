package com.ftn.studentservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileDto {

    private String firstName;
    private String lastName;
    private String email;
    private String indexOrCode;
    //private String code;
    private String id; //from 'User' table
}
