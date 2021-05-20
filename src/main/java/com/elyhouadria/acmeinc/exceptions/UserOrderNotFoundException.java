package com.elyhouadria.acmeinc.exceptions;

public class UserOrderNotFoundException extends RuntimeException {
    public UserOrderNotFoundException(String message) {
        super(message);
    }
}
