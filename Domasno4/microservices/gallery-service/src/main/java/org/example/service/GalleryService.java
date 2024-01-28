package org.example.service;

import org.example.model.Gallery;

import java.util.List;
import java.util.Optional;

public interface GalleryService {
    List<Gallery> listAll();
    List<Gallery> searchByCity(String city);

    List<Gallery> search(String text);

    Optional<Gallery> getGalleryById(Long id);

    String getUpcomingEventTextForGalleryId(long id);
}
