package com.example.user.exceptions;

public class BloodNotFoundException extends RuntimeException {
    public BloodNotFoundException(String message) {
        super(message);
    }
}