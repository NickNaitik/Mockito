package com.example.Mockito.exception;

import com.example.Mockito.model.DictonaryError;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {BussinessException.class})
    public ResponseEntity<BussinessExceptionModel> handleApiRequestException(BussinessException businessException){

        BussinessExceptionModel bussinessExceptionModel = new BussinessExceptionModel();
        bussinessExceptionModel.setErrorMessage(businessException.getErrorMessage());
        bussinessExceptionModel.setErrorDetails(businessException.getErrorDetails());
        bussinessExceptionModel.setErrorCode(businessException.getErrorCode());
        return new ResponseEntity<>(bussinessExceptionModel, HttpStatus.BAD_REQUEST);
    }
}
