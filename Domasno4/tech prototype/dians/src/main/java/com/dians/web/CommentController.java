//package com.dians.web;
//
//import com.dians.model.Comment;
//import com.dians.model.Gallery;
//import com.dians.service.CommentService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/addComment")
//public class CommentController {
//    private final CommentService commentService;
//
//    public CommentController(CommentService commentService) {
//        this.commentService = commentService;
//    }
//
//    @ModelAttribute("comment")
//    public Comment provideCommentModelAttribute() {
//        return new Comment(); // Initialize an empty Comment object
//    }
//
//    @PostMapping("/addComment")
//    public String addComment(@ModelAttribute("comment") Comment comment,
//                             @RequestParam("galleryId") Long galleryId,
//                             Model model) {
//        commentService.addComment(comment.getText(), galleryId);
//
//        // Add 'galleryId' to the model before redirecting
//        model.addAttribute("galleryId", galleryId);
//
//        // Redirect to the details page for the corresponding gallery
//        return "details";
//    }
//}
