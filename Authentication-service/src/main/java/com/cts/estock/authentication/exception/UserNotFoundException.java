package com.cts.estock.authentication.exception;

public class UserNotFoundException extends Exception {

    String message;

    public UserNotFoundException() {

    }

    public String getMessage() {
        return ("User not found");
    }
}
