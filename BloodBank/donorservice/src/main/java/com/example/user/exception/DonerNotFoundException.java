package com.example.user.exception;

public class DonerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DonerNotFoundException(String message) {
        super(message);
    }
}