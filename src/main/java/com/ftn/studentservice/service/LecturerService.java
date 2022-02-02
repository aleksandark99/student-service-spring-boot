package com.ftn.studentservice.service;

import com.ftn.studentservice.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;


}
