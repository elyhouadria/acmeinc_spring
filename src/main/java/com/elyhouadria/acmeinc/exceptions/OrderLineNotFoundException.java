package com.elyhouadria.acmeinc.exceptions;

public class OrderLineNotFoundException extends RuntimeException {
    public OrderLineNotFoundException(String message) {

        super(message);

    }
}
