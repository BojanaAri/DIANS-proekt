package com.dians.web;

import com.dians.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller for handling requests related to gallery details
@Controller
@RequestMapping("/details")
public class DetailsController {

    // Service for interacting with gallery-related data
    private final GalleryService galleryService;

    // Constructor to inject the gallery service
    public DetailsController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    // Handle GET requests to "/details/{id}"
    @GetMapping("/{id}")
    public String getDetailsPage(@PathVariable int id, Model model) {
        // Add attributes to the model indicating the body content and list of galleries
        model.addAttribute("bodyContent", "details");
        model.addAttribute("galleries", galleryService.listAll());

        // Ensure the id is within a valid range before accessing the list
        if (id >= 0 && id < galleryService.listAll().size()) {
            // Add the specific gallery to the model based on the provided id
            model.addAttribute("gallery", galleryService.listAll().get(id));
        } else {
            // Handle invalid id, maybe redirect to an error page
            return "redirect:/error";
        }

        // Return the name of the template to be rendered
        return "master-template";
    }
}
