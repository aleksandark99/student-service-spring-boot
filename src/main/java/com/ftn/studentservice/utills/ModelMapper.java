package com.ftn.studentservice.utills;

import org.springframework.context.annotation.Bean;

public class ModelMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
