package com.ftn.studentservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LecturerDto {

    private Long id;
    private String firstName = "";
    private String lastName = "";
    private String index = "";
}
