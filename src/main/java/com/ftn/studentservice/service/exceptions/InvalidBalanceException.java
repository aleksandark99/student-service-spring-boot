package com.ftn.studentservice.service.exceptions;

public class InvalidBalanceException extends Exception {

    public InvalidBalanceException(String errorMessage) {
        super(errorMessage);
    }
}
