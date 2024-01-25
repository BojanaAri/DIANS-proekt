package com.dians.service;

import com.dians.model.Comment;
import com.dians.model.Gallery;

import java.util.List;
import java.util.Optional;

public interface GalleryService {
    List<Gallery> listAll();
    List<Gallery> searchByCity(String city);

    List<Gallery> search(String text);

    Optional<Gallery> getGalleryById(Long id);
    Boolean searched();

    Comment addComment(String text, String userName, Long galleryId);
    String getUpcomingEventTextForGalleryId(long id);
}
