package com.dians.service.impl;

import com.dians.model.User;
import com.dians.model.exceptions.InvalidUserCredentialsException;
<<<<<<<< HEAD:Domasno3/tech prototype/dians/src/main/java/com/dians/service/impl/AuthServiceImplementation.java
========
import com.dians.model.exceptions.PasswordDoNotMatchException;
>>>>>>>> 6bfefead10acafe1f6aeb7a7e4fbc4f086c62527:Domasno3/tech prototype/dians/src/main/java/com/dians/service/impl/AuthServiceImpl.java
import com.dians.repository.jpa.JpaUserRepository;
import com.dians.service.AuthService;
import org.springframework.stereotype.Service;

@Service
<<<<<<<< HEAD:Domasno3/tech prototype/dians/src/main/java/com/dians/service/impl/AuthServiceImplementation.java
public class AuthServiceImplementation implements AuthService {
========
public class AuthServiceImpl implements AuthService {
>>>>>>>> 6bfefead10acafe1f6aeb7a7e4fbc4f086c62527:Domasno3/tech prototype/dians/src/main/java/com/dians/service/impl/AuthServiceImpl.java

    private final JpaUserRepository userRepository;

    public AuthServiceImpl(JpaUserRepository userRepository) {
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
