package com.dians.repository.inmem;

import com.dians.bootstrap.DataHolder;
import com.dians.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryUserRepository {

    // Method to find a user by username
    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    // Method to find a user by username and password
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return DataHolder.users.stream()
                .filter(user -> user.getUsername().equals(username)
                        && user.getPassword().equals(password))
                .findFirst();
    }

    // Method to save or update a user in the in-memory data holder
    public User saveOrUpdate(User user) {
        DataHolder.users.removeIf(u -> u.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    // Method to delete a user from the in-memory data holder by username
    public void delete(String username) {
        DataHolder.users.removeIf(u -> u.getUsername().equals(username));
    }
}
