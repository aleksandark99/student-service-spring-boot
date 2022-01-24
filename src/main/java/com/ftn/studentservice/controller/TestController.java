package com.ftn.studentservice.controller;


import com.ftn.student_service.api.model.PetResponse;
import com.ftn.student_service.api.spec.v1.PetApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static com.ftn.studentservice.controller.Headers.enrichWithPagingHeaders;
import static  org.springframework.http.ResponseEntity.ok;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
@RestController
public class TestController implements PetApi {

    @Override
    public ResponseEntity<PetResponse> getPetById(String petId) {
        PetResponse pet = new PetResponse();
        pet.setName("aaa");
        return ResponseEntity.ok(pet);    }

    @Override
    public ResponseEntity<List<PetResponse>> getPets() {
        Page examplePage = new Page() {
            @Override
            public int getTotalPages() {
                return 3;
            }

            @Override
            public long getTotalElements() {
                return 60;
            }

            @Override
            public Page map(Function converter) {
                return null;
            }

            @Override
            public int getNumber() {
                return 2;
            }

            @Override
            public int getSize() {
                return 12;
            }

            @Override
            public int getNumberOfElements() {
                return 222;
            }

            @Override
            public List getContent() {
                return null;
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator iterator() {
                return null;
            }
        };
        PetResponse p1 = new PetResponse();
        PetResponse p2 = new PetResponse();
        p1.setName("test1");
        p2.setName("test2");
        return enrichWithPagingHeaders(ok(),examplePage).body(Arrays.asList(p1,p2));
    }

}
