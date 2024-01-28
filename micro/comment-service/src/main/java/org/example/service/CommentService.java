package org.example.service;

import org.example.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment addComment(String text, String userName, Long galleryId);
}
