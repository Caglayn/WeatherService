package com.c8n.weatherservice.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RequiredParameterException.class)
    @Order(value = -1)
    public ResponseEntity<String> handleRequiredParameterException(RequiredParameterException exception){
        return ResponseEntity.status(exception.getStatusCode()).body(exception.getMessage());
    }
}
