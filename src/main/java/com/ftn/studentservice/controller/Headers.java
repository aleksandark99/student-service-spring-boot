package com.ftn.studentservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity.BodyBuilder;

public final  class Headers {

    public static final String PAGE = "Page";
    public static final String ELEMENTS = "Elements";
    public static final String PAGE_SIZE = "Page-Size";
    public static final String TOTAL_PAGES = "Total-Pages";
    public static final String TOTAL_ELEMENTS = "Total-Elements";

    private Headers() {

    }

    static BodyBuilder enrichWithPagingHeaders(BodyBuilder bodyBuilder, Page<?> page){
        return bodyBuilder
                .header(PAGE, Integer.toString(page.getNumber()))
                .header(ELEMENTS, Integer.toString(page.getNumberOfElements()))
                .header(PAGE_SIZE,Integer.toString(page.getSize()))
                .header(TOTAL_PAGES,Integer.toString(page.getTotalPages()))
                .header(TOTAL_ELEMENTS,Long.toString(page.getTotalElements()));
    }
}
