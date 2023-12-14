package com.dians.repository.inmem;

import com.dians.bootstrap.DataHolder;
import com.dians.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    public Optional<User> findByUsername(String username){
        return DataHolder.users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password){
        return DataHolder.users.stream()
                .filter(user -> user.getUsername().equals(username)
                        && user.getPassword().equals(password))
                .findFirst();
    }

    public User saveOrUpdate(User user)
    {
        DataHolder.users.removeIf(u -> u.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    public void delete(String username){
        DataHolder.users.removeIf(u -> u.getUsername().equals(username));
    }

}
