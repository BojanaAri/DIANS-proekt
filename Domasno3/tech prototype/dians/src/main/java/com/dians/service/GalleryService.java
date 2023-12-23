package com.dians.service;

import com.dians.model.Gallery;

import java.util.List;

public interface GalleryService {
    List<Gallery> listAll();

    List<Gallery> search(String address, String name);
    String getGalleryById(Long id);
}
