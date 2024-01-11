package com.dians.web;

import com.dians.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller for handling requests related to the main art galleries page
@Controller
@RequestMapping("/art-galleries")
public class MainController {

    // Service for interacting with gallery-related data
    private final GalleryService galleryService;

    // Constructor to inject the gallery service
    public MainController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    // Handle GET requests to "/art-galleries"
    @GetMapping()
    public String getArtGalleryPage(Model model) {
        // Add attributes to the model indicating the body content and list of galleries
        model.addAttribute("bodyContent", "home");
        model.addAttribute("galleries", galleryService.listAll());
        // Return the name of the template to be rendered
        return "master-template";
    }
}

