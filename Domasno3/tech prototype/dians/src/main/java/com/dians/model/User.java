package com.dians.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String surname;

    // Default constructor (used by JPA)
    public User() {}

    // Constructor to create a User object with specified values
    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}



/*
package com.dians.model;

import jakarta.persistence.*;
import lombok.Data;
// Represents a User entity with associated authentication and personal information
@Data
@Entity
@Table(name = "users")
public class User {
    // Unique identifier for the user (auto-generated)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    // User's login username
    private String password;
    // User's login password
    private String name;
    // User's first name
    private String surname;
    // User's last name

    // Default constructor (used by JPA)
    public User() {}
    // Constructor to create a User object with specified values
    public User(String username, String password, String name, String surname) {
        // Set properties with provided values
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
}
*/
