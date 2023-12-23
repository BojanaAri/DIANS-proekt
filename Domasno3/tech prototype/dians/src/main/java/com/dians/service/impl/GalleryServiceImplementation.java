package com.dians.service.impl;

import com.dians.model.Gallery;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.service.GalleryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryServiceImplementation implements GalleryService {


    private final JpaGalleryRepository galleryRepository;

    public GalleryServiceImplementation(JpaGalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @Override
    public List<Gallery> listAll() {
        return galleryRepository.findAll();
    }

    @Override
    public List<Gallery> searchByCity(String city) {
        return galleryRepository.findAllByCity(city);
    }


    @Override
    public List<Gallery> search(String text) {
        return galleryRepository.findAllByCityOrName(text, "");
    }

    @Override
    public Optional<Gallery> getGalleryById(Long id) {
        return galleryRepository.findById(id);
}}
