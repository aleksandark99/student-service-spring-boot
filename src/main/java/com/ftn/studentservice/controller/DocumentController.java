package com.ftn.studentservice.controller;

import com.ftn.studentservice.dto.request.DocumentRequest;
import com.ftn.studentservice.dto.response.DocumentResponse;
import com.ftn.studentservice.dto.response.LecturerDto;
import com.ftn.studentservice.model.Document;
import com.ftn.studentservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static com.ftn.studentservice.controller.Headers.enrichWithPagingHeaders;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;


    @PostMapping("/upload")
    public ResponseEntity<List<DocumentResponse>> uploadDocument(List<MultipartFile> multipartFiles)  {
//DocumentRequest documentRequest
        final List<Document> documents = documentService.uploadDocument(multipartFiles);

        return ResponseEntity.ok(documents.stream().map(document -> {
            return DocumentResponse.builder()
                    .documentId(document.getId())
                    .documentTitle(document.getTitle())
                    .url(document.getUrl()).build();
        }).collect(Collectors.toList()));
    }

}
