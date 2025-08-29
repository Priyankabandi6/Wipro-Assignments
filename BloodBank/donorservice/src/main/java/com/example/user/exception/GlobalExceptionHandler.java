package com.example.user.exception;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DonerNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleDonerNotFound(DonerNotFoundException ex) {
        ErrorMessage error = new ErrorMessage(ex.getMessage(), "DONER_NOT_FOUND");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class) // fallback for other exceptions
    public ResponseEntity<ErrorMessage> handleGenericException(Exception ex) {
        ErrorMessage error = new ErrorMessage(ex.getMessage(), "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}