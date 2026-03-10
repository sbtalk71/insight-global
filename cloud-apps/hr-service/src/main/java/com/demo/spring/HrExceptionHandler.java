package com.demo.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HrExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handle(RuntimeException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
