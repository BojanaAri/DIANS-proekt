package com.dians.web;

import com.dians.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/details")
public class DetailsController {
    private final GalleryService galleryService;

    public DetailsController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/{id}")
    public String getDetailsPage(@PathVariable int id, @RequestParam(required = false) String hasUpcomingEvents, Model model) {
        // Your controller logic here
        model.addAttribute("bodyContent", "details");
        model.addAttribute("galleries", galleryService.listAll());
        model.addAttribute("hasUpcomingEvents" , hasUpcomingEvents);

        // Ensure the id is within a valid range before accessing the list
        if (id >= 0 && id < galleryService.listAll().size()) {
            model.addAttribute("gallery", galleryService.listAll().get(id));
        } else {
            // Handle invalid id, maybe redirect to an error page
            return "redirect:/error";
        }

        return "master-template";
    }


}
