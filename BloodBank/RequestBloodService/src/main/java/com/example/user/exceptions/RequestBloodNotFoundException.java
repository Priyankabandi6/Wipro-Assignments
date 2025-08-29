package com.example.user.exceptions;

public class RequestBloodNotFoundException extends RuntimeException {
    public RequestBloodNotFoundException(String message) {
        super(message);
    }
}