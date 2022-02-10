package com.ftn.studentservice.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
public class DocumentRequest {

    private List<MultipartFile> multipartFiles;
}
