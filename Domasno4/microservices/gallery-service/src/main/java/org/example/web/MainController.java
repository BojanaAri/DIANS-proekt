package org.example.web;

import org.example.model.Gallery;
import org.example.service.GalleryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/art-galleries","/api"})
public class MainController {

    private final GalleryService galleryService;

    public MainController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping()
    public ResponseEntity<List<Gallery>> getArtGalleries() {
        List<Gallery> galleries = galleryService.listAll();
        return ResponseEntity.ok(galleries);
    }

    @GetMapping("/access_denied")
    public ResponseEntity<String> getAccessDeniedPage() {
        return ResponseEntity.ok("Access Denied");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Gallery>> searchGalleries(@RequestParam String searchText) {
        List<Gallery> galleries = galleryService.search(searchText);
        return ResponseEntity.ok(galleries);
    }
}
