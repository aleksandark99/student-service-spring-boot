package com.ftn.studentservice.controller;

import com.ftn.studentservice.dto.request.DocumentRequest;
import com.ftn.studentservice.dto.response.DocumentResponse;
import com.ftn.studentservice.dto.response.LecturerDto;
import com.ftn.studentservice.model.Document;
import com.ftn.studentservice.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/upload", consumes = {"multipart/form-data"}, method = RequestMethod.POST)
    public List<DocumentResponse> uploadDocuments(@RequestParam("files") List<MultipartFile> multipartFiles)  {

        final List<Document> documents = documentService.uploadDocument(multipartFiles);

        return documents.stream().map(document -> {
            return DocumentResponse.builder()
                    .documentId(document.getId())
                    .documentTitle(document.getTitle())
                    .url(document.getUrl())
                    .createdAt(document.getCreatedAt())
                    .build();
        }).collect(Collectors.toList());
    }

    @GetMapping(value = "/fetch/{id}")
    public List<DocumentResponse> fetchDocuments(@PathVariable("id") Integer studentUserId){
        final List<Document> documents = documentService.fetchDocuments(studentUserId);
        return documents.stream().map(document -> {
            return DocumentResponse.builder()
                    .documentId(document.getId())
                    .documentTitle(document.getTitle())
                    .url(document.getUrl())
                    .createdAt(document.getCreatedAt())
                    .build();
        }).collect(Collectors.toList());
    }

}
