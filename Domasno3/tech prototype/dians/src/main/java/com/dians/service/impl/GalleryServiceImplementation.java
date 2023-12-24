package com.dians.service.impl;

import com.dians.model.Comment;
import com.dians.model.Gallery;
import com.dians.repository.jpa.JpaCommentRepository;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.service.GalleryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryServiceImplementation implements GalleryService {


    private final JpaGalleryRepository galleryRepository;
    private final JpaCommentRepository commentRepository;

    public GalleryServiceImplementation(JpaGalleryRepository galleryRepository, JpaCommentRepository commentRepository) {
        this.galleryRepository = galleryRepository;
        this.commentRepository = commentRepository;
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
        return galleryRepository.findAllByCityOrName(text);
    }

    @Override
    public Optional<Gallery> getGalleryById(Long id) {
        return galleryRepository.findById(id);
}

@Override
public Boolean searched()
    {
        return true;
    }



    @Override
    public Comment addComment(String text, Long galleryId) {
        Comment comment = new Comment(text);
        Gallery gallery = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new RuntimeException("Gallery not found with id: " +galleryId));
        comment.setGallery(gallery);
        return commentRepository.save(comment);
    }
}

