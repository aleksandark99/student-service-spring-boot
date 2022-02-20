package com.ftn.studentservice.controller;


import com.ftn.student_service.api.model.PetResponse;
import com.ftn.student_service.api.spec.v1.PetApi;
import com.ftn.studentservice.service.ExamPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import static com.ftn.studentservice.controller.Headers.enrichWithPagingHeaders;
import static org.springframework.http.ResponseEntity.ok;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@RestController
public class TestController {



}
