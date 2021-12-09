package com.cts.estock.authentication.exception;

public class UserAlreadyExist extends Exception {
    private static final long serialVersionUID = 1L;

    public UserAlreadyExist(String s) {

    }

    public String getMessage() {
        return ("User already exists");
    }
}
