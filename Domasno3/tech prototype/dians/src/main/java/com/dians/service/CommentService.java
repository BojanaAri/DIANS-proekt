package com.dians.service;

import com.dians.model.Comment;

import java.util.List;

public interface CommentService {

    Comment addComment(String text, String userName, Long galleryId);
    List<Comment> findAll();

    List<Comment> getCommentsByGalleryId(Long galleryId);
}
