package com.bookmyshow.exceptions;

public class ShowNotFoundException extends Exception {
    public ShowNotFoundException() {
        super();
    }

    public ShowNotFoundException(String message) {
        super(message);
    }
}
