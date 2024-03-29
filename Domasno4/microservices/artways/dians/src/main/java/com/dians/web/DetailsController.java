package com.dians.web;
import com.dians.model.Comment;
import com.dians.model.Gallery;
import com.dians.service.CommentService;
import com.dians.service.GalleryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/details")
public class DetailsController {
    private final GalleryService galleryService;
    private final CommentService commentService;

    public DetailsController(GalleryService galleryService, CommentService commentService) {
        this.galleryService = galleryService;
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getDetailsPage(@PathVariable long id, Model model) {
        // Your controller logic here

        // Ensure the id is within a valid range before accessing the list
        if (id >= 0 && id < galleryService.listAll().size()) {
            Gallery gallery = galleryService.getGalleryById(id).orElseThrow();
            model.addAttribute("gallery", gallery);

            List<Comment> comments = commentService.getCommentsByGalleryId(id);
            if (comments != null && !comments.isEmpty()){
                model.addAttribute("commentsExist", true);
                model.addAttribute("comments", comments);
            }
            else {
                model.addAttribute("commentsExist", false);
            }

        } else {
            // Handle invalid id, maybe redirect to an error page
            return "redirect:/error";
        }

        String upcomingEventText = galleryService.getUpcomingEventTextForGalleryId(id);
        model.addAttribute("upcomingEventText", upcomingEventText);

        model.addAttribute("bodyContent", "details");
        return "master-template";
    }



}