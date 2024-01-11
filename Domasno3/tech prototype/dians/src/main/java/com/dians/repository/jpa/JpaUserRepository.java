package com.dians.repository.jpa;

import com.dians.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JPA repository interface for User entities
public interface JpaUserRepository extends JpaRepository<User, Long> {
    // Find a user by their username
    Optional<User> findByUsername(String username);
    // Find a user by their username and password
    Optional<User> findByUsernameAndPassword(String username, String password);
}


