package org.example.web;

import org.example.service.GalleryService;
import org.example.model.Gallery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailsController {
    private final GalleryService galleryService;

    public DetailsController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDetailsPage(@PathVariable long id, Model model) {
        // Your controller logic here

        // Ensure the id is within a valid range before accessing the list
        if (id >= 0 && id < galleryService.listAll().size()) {
            Gallery gallery = galleryService.getGalleryById(id).orElseThrow();
            model.addAttribute("gallery", gallery);


        } else {
            // Handle invalid id, maybe return an error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid gallery ID");
        }

        String upcomingEventText = galleryService.getUpcomingEventTextForGalleryId(id);
        model.addAttribute("upcomingEventText", upcomingEventText);

        model.addAttribute("bodyContent", "details");
        return ResponseEntity.ok(model);
    }
}
