package com.gl.homework.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3332292346834265371L;

    public UserNotFoundException(int id) {
        super("User with id = " + id + " cannot be found in the database.");
    }
}

