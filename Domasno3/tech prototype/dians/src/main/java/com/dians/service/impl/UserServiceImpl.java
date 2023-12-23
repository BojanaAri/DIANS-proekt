package com.dians.service.impl;

import com.dians.model.Role;
import com.dians.model.User;
import com.dians.model.exceptions.InvalidArgumentExceptions;
import com.dians.model.exceptions.PasswordDoNotMatchException;
import com.dians.model.exceptions.UsernameAlreadyExistsException;
import com.dians.repository.jpa.JpaUserRepository;
import com.dians.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(JpaUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) throws InvalidArgumentExceptions, PasswordDoNotMatchException {
        if (username == null || username.isEmpty()|| password==null || password.isEmpty())
            throw new InvalidArgumentExceptions();

        if (!password.equals(repeatPassword))
            throw new PasswordDoNotMatchException();

        if (this.userRepository.findByUsernameAndPassword(username,password).isPresent())
            throw new UsernameAlreadyExistsException(username);

        User user = new User(username,
                passwordEncoder.encode(password),
                name, surname, Role.ROLE_USER);
        this.userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
