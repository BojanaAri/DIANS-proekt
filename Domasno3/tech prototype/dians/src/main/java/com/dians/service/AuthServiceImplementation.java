package com.dians.service;

import com.dians.model.User;
import com.dians.model.exceptions.InvalidArgumentExceptions;
import com.dians.model.exceptions.InvalidUserCredentialsException;
import com.dians.model.exceptions.PasswordDoNotMatchException;
import com.dians.repository.jpa.JpaUserRepository;
import org.springframework.stereotype.Service;

// Service implementation for authentication and registration
@Service
public class AuthServiceImplementation implements AuthService {

    // Repository for user data storage
    private final JpaUserRepository userRepository;

    // Constructor to inject the user repository
    public AuthServiceImplementation(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Attempt to log in with the provided username and password
    // Throws InvalidUserCredentialsException if the credentials are invalid
    @Override
    public User login(String username, String password) throws InvalidUserCredentialsException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidUserCredentialsException();
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    // Attempt to register a new user with the provided information
    // Throws InvalidArgumentExceptions for invalid input and PasswordDoNotMatchException if passwords do not match
    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname)
            throws InvalidArgumentExceptions, PasswordDoNotMatchException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidArgumentExceptions();

        if (!password.equals(repeatPassword))
            throw new PasswordDoNotMatchException();

        // Create a new user and save to the repository
        User user = new User(username, password, name, surname);
        userRepository.save(user);
        return user;
    }
}
