package com.trisha.productapp;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> handleException(RuntimeException e){
        return ResponseEntity
                .status(404)
                .body(new ApiResponse(e.getMessage(),null));
    }
}
