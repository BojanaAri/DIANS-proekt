package com.dians.service;

import com.dians.model.Gallery;

import java.util.List;

public interface GalleryService {
    List<Gallery> listAll();

    List<Gallery> searchByCity(String city);

    List<Gallery> search(String text);
}
