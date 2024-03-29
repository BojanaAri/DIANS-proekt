package org.example.service;

import com.dians.model.exceptions.InvalidArgumentExceptions;
import com.dians.model.exceptions.PasswordDoNotMatchException;
import com.dians.model.exceptions.UsernameAlreadyExistsException;
import org.example.repository.JpaUserRepository;
import org.example.model.Role;
import org.example.model.User;
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

        if (this.userRepository.findByUsername(username).isPresent())
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
