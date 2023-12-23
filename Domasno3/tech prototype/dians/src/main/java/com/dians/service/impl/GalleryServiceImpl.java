package com.dians.service.impl;

import com.dians.model.Gallery;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.service.GalleryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
<<<<<<<< HEAD:Domasno3/tech prototype/dians/src/main/java/com/dians/service/impl/GalleryServiceImplementation.java
public class GalleryServiceImplementation implements GalleryService {
========
public class GalleryServiceImpl implements GalleryService {
>>>>>>>> 6bfefead10acafe1f6aeb7a7e4fbc4f086c62527:Domasno3/tech prototype/dians/src/main/java/com/dians/service/impl/GalleryServiceImpl.java

    private final JpaGalleryRepository galleryRepository;

    public GalleryServiceImpl(JpaGalleryRepository galleryRepository) {
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

    @Override
    public String getGalleryById(Long id) {
        return galleryRepository.getGalleryById(id);
    }
}
