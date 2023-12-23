package com.dians.service.impl;

import com.dians.model.Gallery;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.service.GalleryService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Gallery> search(String address, String name) {
        return galleryRepository.searchAllByAddressAndName(address, name);
    }
}
