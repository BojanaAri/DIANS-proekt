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

    // Text content of the comment
    String text;

    // Many-to-One relationship with Gallery entity using gallery_id foreign key
    @ManyToOne
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

