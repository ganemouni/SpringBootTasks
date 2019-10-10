package com.stackroute.exceptions;

import com.stackroute.domain.MovieApp;

public class MovieNotFoundException extends Exception {
    private String message;

    public MovieNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
