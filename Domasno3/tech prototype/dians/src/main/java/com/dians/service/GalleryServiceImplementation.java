package com.dians.service;

import com.dians.model.Gallery;
import com.dians.repository.jpa.JpaGalleryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Service implementation for gallery-related operations
@Service
public class GalleryServiceImplementation implements GalleryService {

    // Repository for gallery data storage
    private final JpaGalleryRepository galleryRepository;

    // Constructor to inject the gallery repository
    public GalleryServiceImplementation(JpaGalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    // Retrieve a list of all galleries
    @Override
    public List<Gallery> listAll() {
        return galleryRepository.findAll();
    }

    // Search for galleries based on address and name
    @Override
    public List<Gallery> search(String address, String name) {
        return galleryRepository.searchAllByAddressAndName(address, name);
    }
}
