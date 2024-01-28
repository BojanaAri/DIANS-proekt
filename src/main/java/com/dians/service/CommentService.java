package com.dians.service;

import com.dians.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    List<Comment> getCommentsByGalleryId(Long galleryId);

    Comment addComment(String text, String userName, Long galleryId);
}
