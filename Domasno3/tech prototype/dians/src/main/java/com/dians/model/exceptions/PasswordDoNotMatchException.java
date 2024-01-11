package com.dians.model.exceptions;

// Custom exception class for password mismatch
public class PasswordDoNotMatchException extends Exception {

    // Private static instance of PasswordDoNotMatchException
    private static volatile PasswordDoNotMatchException instance;

    // Private constructor to prevent external instantiation
    public PasswordDoNotMatchException() {
        super("Passwords do not match");
    }

    // Public method to get the instance of PasswordDoNotMatchException
    public static PasswordDoNotMatchException getInstance() {
        if (instance == null) {
            synchronized (PasswordDoNotMatchException.class) {
                if (instance == null) {
                    instance = new PasswordDoNotMatchException();
                }
            }
        }
        return instance;
    }
}



/*
package com.dians.model.exceptions;
// Custom exception class for password mismatch
public class PasswordDoNotMatchException extends Exception {
    // Default constructor with a predefined error message
    public PasswordDoNotMatchException() {
        super("Passwords do not match");
    }
}
*/