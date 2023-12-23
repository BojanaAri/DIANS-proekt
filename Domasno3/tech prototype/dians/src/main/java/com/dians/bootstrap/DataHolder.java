package com.dians.bootstrap;

import com.dians.model.Comment;
import com.dians.model.Gallery;
import com.dians.model.Role;
import com.dians.model.User;
import com.dians.repository.jpa.JpaCommentRepository;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.repository.jpa.JpaUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataHolder {
    public static List<Gallery> galleries;
    public static List<User> users;

    public static List<Comment> comments;
    private final JpaGalleryRepository galleryRepository;
    private final JpaUserRepository userRepository;
    private final JpaCommentRepository commentRepository;
    private final PasswordEncoder passwordEncoder;

    public DataHolder(JpaGalleryRepository galleryRepository, JpaUserRepository userRepository, JpaCommentRepository commentRepository, PasswordEncoder passwordEncoder) {
        this.galleryRepository = galleryRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
       this.passwordEncoder = passwordEncoder;
    }
  
    @PostConstruct
    public void init() {
        galleries = new ArrayList<>();
        users = new ArrayList<>();
        comments = new ArrayList<>();

        if (userRepository.count() == 0) {
            users.add(new User("bojana.ari",
                            passwordEncoder.encode("ba"),
                            "bojana",
                            "arizankovska",
                             Role.ROLE_USER));
            users.add(new User("marija.aceska",
                    passwordEncoder.encode("ma"),
                    "marija",
                    "aceska",
                    Role.ROLE_USER));
            users.add(new User("martina.kuzmanovska",
                    passwordEncoder.encode("mk"),
                    "martina",
                    "kuzmanovska",
                    Role.ROLE_USER));
            users.add(new User("elena.baleska",
                    passwordEncoder.encode("eb"),
                    "elena",
                    "baleska",
                    Role.ROLE_USER));
            users.add(new User("bisera.galeska",
                    passwordEncoder.encode("bg"),
                    "bisera",
                    "galeska",
                    Role.ROLE_USER));
            users.add(new User("admin",
                    passwordEncoder.encode("admin"),
                    "admin",
                    "admin",
                    Role.ROLE_USER));
            userRepository.saveAll(users);
        }

        if (galleryRepository.count() == 0) {
            this.galleries = readJsonFile("src/main/resources/galleriesList.json");
            galleryRepository.saveAll(galleries);
        }

        if (commentRepository.count() == 0) {
            comments.add(new Comment("good"));
            commentRepository.saveAll(comments);
        }
    }

    private List<Gallery> readJsonFile(String filepath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filepath),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Gallery.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

