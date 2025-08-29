package com.example.user.exceptions;

import java.time.LocalDateTime;

public class ErrorMessage {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorMessage(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

}