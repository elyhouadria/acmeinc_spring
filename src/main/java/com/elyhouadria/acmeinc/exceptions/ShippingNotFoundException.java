package com.elyhouadria.acmeinc.exceptions;

public class ShippingNotFoundException extends RuntimeException {
    public ShippingNotFoundException(String message) {
        super(message);
    }
}
