package com.dians.service;

import com.dians.model.Gallery;
import com.dians.repository.GalleryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryServiceImplementation implements GalleryService{

    private final GalleryRepository galleryRepository;

    public GalleryServiceImplementation(GalleryRepository galleryRepository) {
        this.galleryRepository = galleryRepository;
    }

    @Override
    public List<Gallery> listAll() {
        return galleryRepository.findAll();
    }

    @Override
    public List<Gallery> search(String text) {
        return galleryRepository.search(text);
    }
}
