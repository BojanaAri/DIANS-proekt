package com.dians.service;

import com.dians.model.Gallery;

import java.util.List;

// Interface defining services related to galleries
public interface GalleryService {

    // Retrieve a list of all galleries
    List<Gallery> listAll();

    // Search for galleries based on address and name
    List<Gallery> search(String address, String name);
}
