package org.example.web;

import lombok.extern.slf4j.Slf4j;
import org.example.service.CommentService;
import org.example.model.Comment;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments/{id}")
    public Comment addComment(@RequestParam("comment") String comment,
                              @PathVariable Long id,
                              @RequestParam String nameUser) {

        // Invoke the service method to add the comment
        return commentService.addComment(comment, nameUser, id);
    }
}
