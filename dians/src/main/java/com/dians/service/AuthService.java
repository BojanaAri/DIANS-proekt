package com.dians.service;

import com.dians.model.User;
import com.dians.model.exceptions.InvalidArgumentExceptions;
import com.dians.model.exceptions.InvalidUserCredentialsException;
import com.dians.model.exceptions.PasswordDoNotMatchException;

public interface AuthService {
    User login(String username, String password)  throws InvalidUserCredentialsException;
}
