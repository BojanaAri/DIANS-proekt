package com.dians.model.exceptions;

public class PasswordDoNotMatchException extends Exception{
    public PasswordDoNotMatchException() {
        super("Passwords do not match");
    }
}
