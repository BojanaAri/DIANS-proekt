package com.dians.service.impl;

import com.dians.model.Comment;
import com.dians.model.Gallery;
import com.dians.repository.jpa.JpaCommentRepository;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final JpaCommentRepository commentRepository;
    private final JpaGalleryRepository galleryRepository;

    public CommentServiceImpl(JpaCommentRepository commentRepository, JpaGalleryRepository galleryRepository) {
        this.commentRepository = commentRepository;
        this.galleryRepository = galleryRepository;
    }

    @Override
    public Comment addComment(String text,String userName, Long galleryId) {
        Comment comment = new Comment(text,userName);
        Gallery gallery = galleryRepository.findById(galleryId)
                .orElseThrow(() -> new RuntimeException("Gallery not found with id: " +galleryId));
        comment.setGallery(gallery);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentsByGalleryId(Long galleryId) {
        return commentRepository.findByGalleryId(galleryId);
    }
}
