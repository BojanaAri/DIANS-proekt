package com.dians.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    public User() {

    }

//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Comment> comments;

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }



}
