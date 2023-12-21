package com.dians.bootstrap;

import com.dians.model.Gallery;
import com.dians.model.User;
import com.dians.repository.inmem.GalleryRepository;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.repository.jpa.JpaUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Gallery> galleries;
    public static List<User> users;
    private final JpaGalleryRepository galleryRepository;
    private final JpaUserRepository userRepository;


    public DataHolder(JpaGalleryRepository galleryRepository, JpaUserRepository userRepository) {
        this.galleryRepository = galleryRepository;
        this.userRepository = userRepository;
    }
    @PostConstruct
    public void init() {
        galleries = new ArrayList<>();
        users = new ArrayList<>();

        if (galleryRepository.count() == 0) {
            this.galleries = readJsonFile("src/main/resources/galleriesList.json");
            galleryRepository.saveAll(galleries);
        }

        if (userRepository.count() == 0) {
            users.add(new User("bokismoki","bs", "boki", "smoki"));
            userRepository.saveAll(users);
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

