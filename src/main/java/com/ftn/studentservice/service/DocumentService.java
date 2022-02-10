package com.ftn.studentservice.service;

import com.ftn.studentservice.dto.request.DocumentRequest;
import com.ftn.studentservice.dto.response.DocumentResponse;
import com.ftn.studentservice.model.Document;
import com.ftn.studentservice.model.Student;
import com.ftn.studentservice.repository.DocumentRepository;
import com.ftn.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {

    @Value("${minio.bucket.attachment}")
    private String minioBucketAttachment;

    @Autowired
    private MinioService minioService;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository; //for test only!!!
//DocumentRequest documentRequest
    public List<Document> uploadDocument(List<MultipartFile> multipartFiles){
        List<Document> documents = new ArrayList<>();
        //final Student loggedInStudent = studentService.getLoggedInStudent(); //Uncomment for Exam!!!

        final Student student1 = studentRepository.findByUser_Id(1L); //for test only!!!

        multipartFiles.forEach(multipartAttachment -> {

            try {
                String objectName = System.currentTimeMillis() + "_" + multipartAttachment.getOriginalFilename();
                Document newDocument = Document.builder()
                        .mimeType(multipartAttachment.getContentType())
                        .title(multipartAttachment.getOriginalFilename())
                        .objectName(objectName)
                        .url(minioService.save(multipartAttachment.getInputStream(), minioBucketAttachment, objectName, multipartAttachment.getOriginalFilename(), multipartAttachment.getContentType()))
                        .student(student1) //for test only!!!
                        //.student(loggedInStudent) //Uncomment for Exam!!!
                        .build();
                final Document save = documentRepository.save(newDocument);
                documents.add(save);

            } catch (IOException e) {
                e.printStackTrace();
                throw new  IllegalArgumentException("Cannot convert InputStream!");
            }

        });

        return documents;

    }
}
