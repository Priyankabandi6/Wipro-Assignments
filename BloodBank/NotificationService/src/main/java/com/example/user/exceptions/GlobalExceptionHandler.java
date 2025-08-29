package com.example.user.exceptions;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotificationNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotificationNotFound(NotificationNotFoundException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}