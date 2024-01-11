package com.dians.model.exceptions;

// Custom exception class for invalid user credentials
public class InvalidUserCredentialsException extends Exception {

    // Private static instance of InvalidUserCredentialsException
    private static volatile InvalidUserCredentialsException instance;

    // Private constructor to prevent external instantiation
    public InvalidUserCredentialsException() {
        super("Invalid user credentials");
    }

    // Public method to get the instance of InvalidUserCredentialsException
    public static InvalidUserCredentialsException getInstance() {
        if (instance == null) {
            synchronized (InvalidUserCredentialsException.class) {
                if (instance == null) {
                    instance = new InvalidUserCredentialsException();
                }
            }
        }
        return instance;
    }
}


/*
package com.dians.model.exceptions;
// Custom exception class for invalid user credentials
public class InvalidUserCredentialsException extends Exception {
    // Default constructor with a predefined error message
    public InvalidUserCredentialsException() {
        super("Invalid user credentials");
    }
}
*/