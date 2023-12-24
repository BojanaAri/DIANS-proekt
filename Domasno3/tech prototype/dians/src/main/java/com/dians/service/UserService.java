package com.dians.service;

import com.dians.model.User;
import com.dians.model.exceptions.InvalidArgumentExceptions;
import com.dians.model.exceptions.PasswordDoNotMatchException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname) throws InvalidArgumentExceptions, PasswordDoNotMatchException;

}
