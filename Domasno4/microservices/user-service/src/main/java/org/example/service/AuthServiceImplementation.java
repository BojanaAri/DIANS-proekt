package org.example.service;

import com.dians.model.exceptions.InvalidUserCredentialsException;
import org.example.repository.JpaUserRepository;
import org.example.model.User;
import org.springframework.stereotype.Service;

@Service

public class AuthServiceImplementation implements AuthService {


    private final JpaUserRepository userRepository;

    public AuthServiceImplementation(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) throws InvalidUserCredentialsException {
        if (username == null || username.isEmpty() || password==null || password.isEmpty())
            throw new InvalidUserCredentialsException();
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }

   /* @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) throws InvalidArgumentExceptions, PasswordDoNotMatchException {
        if (username == null || username.isEmpty()|| password==null || password.isEmpty())
            throw new InvalidArgumentExceptions();

        if (!password.equals(repeatPassword))
            throw new PasswordDoNotMatchException();

        User user = new User(username, password,name, surname);
        userRepository.save(user);
        return user;
    }*/
}
