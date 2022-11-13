package com.springboot.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(BussinessException.class)
    public ResponseEntity<ResponseError> businesssException(BussinessException bussinessException) {
        ResponseError responseError = new ResponseError(bussinessException.getMessage(),
                LocalDateTime.now(), "bank-service");

        return ResponseEntity.badRequest().body(responseError);
    }
}
