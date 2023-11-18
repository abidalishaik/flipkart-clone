package com.flipkartclone.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<APIResponse> entityNotFoundException(EntityNotFoundException exception) {
        APIResponse response = new APIResponse();
        response.setMessage(exception.getMessage());
        response.setStatusCode(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(response);
    }

}
