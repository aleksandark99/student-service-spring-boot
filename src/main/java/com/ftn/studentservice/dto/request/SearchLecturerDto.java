package com.ftn.studentservice.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchLecturerDto {


    private int pageNo;
    private int pageSize;
    private String searchWord;
}
