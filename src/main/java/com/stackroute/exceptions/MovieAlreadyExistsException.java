package com.stackroute.exceptions;

public class MovieAlreadyExistsException extends Exception {
    private String message;

    public MovieAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}

