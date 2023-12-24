package com.dians.web;
import com.dians.model.Comment;
import com.dians.model.Gallery;
import com.dians.service.CommentService;
import com.dians.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    public String getDetailsPage(@PathVariable long id, @RequestParam(required = false) boolean hasUpcomingEvents, Model model) {

        // Your controller logic here
        model.addAttribute("bodyContent", "details");
        model.addAttribute("galleries", galleryService.listAll());
        model.addAttribute("hasUpcomingEvents" , hasUpcomingEvents);

        // Ensure the id is within a valid range before accessing the list
        if (id >= 0 && id < galleryService.listAll().size()) {
            Gallery gallery = galleryService.getGalleryById(id).orElseThrow();
            model.addAttribute("gallery", gallery);

            List<Comment> comments = this.commentService.findAll();
            if (comments != null && !comments.isEmpty()){
                model.addAttribute("commentsExist", true);
                model.addAttribute("comments", commentService.getCommentsByGalleryId(id));
            }
            else {
                model.addAttribute("commentsExist", false);
            }

        } else {
            // Handle invalid id, maybe redirect to an error page
            return "redirect:/error";
        }

        if (hasUpcomingEvents) {
            String upcomingEventText = getUpcomingEventTextForGalleryId(id);
            model.addAttribute("upcomingEventText", upcomingEventText);
        }


        return "master-template";
    }
    private String getUpcomingEventTextForGalleryId(long id) {
        switch ((int)id) {
            case 1:
                return "Почеток: декември 7 @ 19:30     Крај: јануари 14, 2024 @ 18:00     Cost: MKD100";
            case 19:
                return "Почеток: декември 20 @ 12:00     Крај: февруари 4, 2024 @ 18:00     Cost: MKD100";
            case 2:
                return "Почеток: декември 24 @ 19:00     Крај: јануари 15 @ 18:00     Cost: MKD100";
            default:
                return "Default upcoming event text";
        }
    }


    @PostMapping("/addComment")
    public String addComment(@ModelAttribute("comment") Comment comment,
                             @RequestParam("galleryId") Long galleryId,
                             Model model) {
        // Validate input parameters
        if (comment == null || galleryId == null) {
            // Handle invalid input, maybe redirect to an error page
            return "redirect:/error";
        }

        // Invoke the service method to add the comment
//        commentService.addComment(comment.getText(), galleryId);
        galleryService.addComment(comment.getText(), galleryId);

        // Redirect to the details page for the corresponding gallery
        return "redirect:/details/" + galleryId;
    }
}