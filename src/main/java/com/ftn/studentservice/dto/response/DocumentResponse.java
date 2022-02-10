package com.ftn.studentservice.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DocumentResponse {

    private String url;
    private Long documentId;
    private String documentTitle;
    private String createdAt;
}
