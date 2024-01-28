package com.dians.model.exceptions;

public class InvalidUserCredentialsException extends Exception{
    public InvalidUserCredentialsException() {
        super("Invalid user credentials");
}
}
