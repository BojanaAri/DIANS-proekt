package com.dians.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    // Primary key for the comment entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String text;
    String nameOfUser;

    public Comment(String text, String nameOfUser) {
        this.text = text;
        this.nameOfUser = nameOfUser;
    }

    // Text content of the comment
    String text;


//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    // Constructors

    // Parameterized constructor to create a comment with text
    public Comment(String text) {
        this.text = text;
    }

    // Default constructor (no-args) required for JPA
    public Comment() {
    }
}

