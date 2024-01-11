package com.dians.repository.inmem;

import com.dians.bootstrap.DataHolder;
import com.dians.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Repository class for in-memory storage of User entities
@Repository
public class UserRepository {

    // Find a user by their username
    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    // Find a user by their username and password
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return DataHolder.users.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();
    }

    // Save or update a user in the in-memory storage
    public User saveOrUpdate(User user) {
        // Remove any existing user with the same username and add the updated user
        DataHolder.users.removeIf(u -> u.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    // Delete a user by their username
    public void delete(String username) {
        // Remove the user with the specified username from the in-memory storage
        DataHolder.users.removeIf(u -> u.getUsername().equals(username));
    }
}

