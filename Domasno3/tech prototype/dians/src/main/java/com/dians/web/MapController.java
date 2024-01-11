package com.dians.web;

import com.dians.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller for handling requests related to the map page
@Controller
@RequestMapping("/map")
public class MapController {

    // Service for interacting with gallery-related data
    private final GalleryService galleryService;

    // Constructor to inject the gallery service
    public MapController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    // Handle GET requests to "/map"
    @GetMapping()
    public String getMapPage(Model model) {
        // Add attributes to the model indicating the body content and list of galleries
        model.addAttribute("bodyContent", "map");
        model.addAttribute("galleries", galleryService.listAll());
        // Return the name of the template to be rendered
        return "master-template";
    }
}

