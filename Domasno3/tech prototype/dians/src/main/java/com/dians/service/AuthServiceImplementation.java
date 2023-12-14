package com.dians.service;

import com.dians.model.User;
import com.dians.model.exceptions.InvalidArgumentExceptions;
import com.dians.model.exceptions.InvalidUserCredentialsException;
import com.dians.model.exceptions.PasswordDoNotMatchException;
import com.dians.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService{

    private final UserRepository userRepository;

    public AuthServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) throws InvalidUserCredentialsException {
        if (username == null || username.isEmpty() || password==null || password.isEmpty())
            throw new InvalidUserCredentialsException();
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) throws InvalidArgumentExceptions, PasswordDoNotMatchException {
        if (username == null || username.isEmpty()|| password==null || password.isEmpty())
            throw new InvalidArgumentExceptions();

        if (!password.equals(repeatPassword))
            throw new PasswordDoNotMatchException();

        User user = new User(username, password,name, surname);
        userRepository.saveOrUpdate(user);
        return user;
    }
}
