package com.dians.model.exceptions;
// Custom exception class for invalid arguments
public class InvalidArgumentExceptions extends Exception {
    // Default constructor with a predefined error message
    public InvalidArgumentExceptions() {
        super("Invalid arguments!");
    }
}