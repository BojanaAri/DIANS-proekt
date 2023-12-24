package com.dians.repository.jpa;

import com.dians.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByGalleryId(Long id);
}
