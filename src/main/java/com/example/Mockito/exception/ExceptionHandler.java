package com.example.Mockito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BussinessException.class})
    public ResponseEntity<BussinessException> handleApiRequestException(BussinessException businessException){
        System.out.println("YNHA AAYA ");
        return new ResponseEntity<>(businessException, HttpStatus.BAD_REQUEST);
    }
}
