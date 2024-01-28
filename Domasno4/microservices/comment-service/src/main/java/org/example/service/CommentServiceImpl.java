package org.example.service;

import org.example.repository.JpaCommentRepository;
import org.example.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final JpaCommentRepository commentRepository;

    public CommentServiceImpl(JpaCommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }


    @Override
    public Comment addComment(String text, String userName, Long galleryId) {
        Comment comment = new Comment(text, userName);
        return commentRepository.save(comment);
    }
}
