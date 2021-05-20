package com.elyhouadria.acmeinc.exceptions;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String message){
        super(message);
    }
}
