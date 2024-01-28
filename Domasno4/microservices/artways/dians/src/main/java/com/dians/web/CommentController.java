package com.dians.web;

import com.dians.model.Comment;
import com.dians.service.CommentService;
import com.dians.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments/{id}")
    public String addComment(@RequestParam("comment") String comment,
                             @PathVariable Long id,
                             @RequestParam String nameUser) {
        // Validate input parameters
        if (comment == null || id == null) {
            return "redirect:/error";
        }

        // Invoke the service method to add the comment
        commentService.addComment(comment, nameUser, id);

        // Redirect to the details page for the corresponding gallery
        return "redirect:/details/" + id;
    }
}
