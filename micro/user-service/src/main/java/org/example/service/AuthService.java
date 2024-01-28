package org.example.service;

import com.dians.model.exceptions.InvalidUserCredentialsException;
import org.example.model.User;

public interface AuthService {
    User login(String username, String password)  throws InvalidUserCredentialsException;
}
