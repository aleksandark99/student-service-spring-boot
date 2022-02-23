package com.ftn.studentservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCourseInstanceDto {

    private Integer courseId;
    private String startDate;
    private String endDate;

}
