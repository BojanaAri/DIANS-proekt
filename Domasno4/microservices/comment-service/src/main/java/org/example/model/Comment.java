package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

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
    String nameOfUser;
    LocalDate timestamp;
    // Constructors

    // Parameterized constructor to create a comment with text
    public Comment(String text, String nameOfUser) {
        this.text = text;
        this.nameOfUser = nameOfUser;
        this.timestamp = LocalDate.now();
    }

    // Default constructor (no-args) required for JPA
    public Comment() {
    }
}

