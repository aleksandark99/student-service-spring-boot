package com.ftn.studentservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchStudentDto {

    private int pageNo;
    private int pageSize;
    private String searchWord;
/*    private String firstName = "";
    private String lastName = "";
    private String index = "";*/
}
