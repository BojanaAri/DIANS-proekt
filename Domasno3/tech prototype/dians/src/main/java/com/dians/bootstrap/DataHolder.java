package com.dians.bootstrap;

import com.dians.model.Gallery;
import com.dians.model.User;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.repository.jpa.JpaUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Indicates that the class is a Spring component
@Component
public class DataHolder {

    // Static lists to hold in-memory data for galleries and users
    public static List<Gallery> galleries;
    public static List<User> users;

    // JPA repositories for galleries and users
    private final JpaGalleryRepository galleryRepository;
    private final JpaUserRepository userRepository;

    // Constructor to inject JPA repositories
    public DataHolder(JpaGalleryRepository galleryRepository, JpaUserRepository userRepository) {
        this.galleryRepository = galleryRepository;
        this.userRepository = userRepository;
    }

    // Method annotated with @PostConstruct to initialize data after the bean creation
    @PostConstruct
    public void init() {
        galleries = new ArrayList<>();
        users = new ArrayList<>();

        // If there are no galleries in the database, read from a JSON file and save to the database
        if (galleryRepository.count() == 0) {
            this.galleries = readJsonFile("src/main/resources/galleriesList.json");
            galleryRepository.saveAll(galleries);
        }

        // If there are no users in the database, add a default user and save to the database
        if (userRepository.count() == 0) {
            users.add(new User("bokismoki","bs", "boki", "smoki"));
            userRepository.saveAll(users);
        }
    }

    // Method to read galleries from a JSON file
    private List<Gallery> readJsonFile(String filepath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filepath),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Gallery.class));
        } catch (IOException e) {
            // Throw a RuntimeException if an exception occurs during JSON file reading
            throw new RuntimeException(e);
        }
    }
}
