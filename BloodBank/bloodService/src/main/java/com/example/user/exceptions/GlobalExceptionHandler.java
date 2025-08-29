package com.example.user.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle Blood not found
    @ExceptionHandler(BloodNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBloodNotFound(BloodNotFoundException ex, WebRequest request) {
        ErrorMessage error = new ErrorMessage(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex, WebRequest request) {
        ErrorMessage error = new ErrorMessage(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}