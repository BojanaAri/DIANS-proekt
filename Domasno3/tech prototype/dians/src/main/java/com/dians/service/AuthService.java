package com.dians.service;

import com.dians.model.User;
import com.dians.model.exceptions.InvalidArgumentExceptions;
import com.dians.model.exceptions.InvalidUserCredentialsException;
import com.dians.model.exceptions.PasswordDoNotMatchException;

// Interface defining authentication and registration services
public interface AuthService {

    // Attempt to log in with the provided username and password
    // Throws InvalidUserCredentialsException if the credentials are invalid
    User login(String username, String password) throws InvalidUserCredentialsException;

    // Attempt to register a new user with the provided information
    // Throws InvalidArgumentExceptions for invalid input and PasswordDoNotMatchException if passwords do not match
    User register(String username, String password, String repeatPassword, String name, String surname)
            throws InvalidArgumentExceptions, PasswordDoNotMatchException;
}

