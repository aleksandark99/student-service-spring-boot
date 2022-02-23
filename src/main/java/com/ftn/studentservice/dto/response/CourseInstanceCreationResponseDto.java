package com.ftn.studentservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseInstanceCreationResponseDto {

    private Long courseInstanceId;
    private boolean successful;
    private String reason;
}
