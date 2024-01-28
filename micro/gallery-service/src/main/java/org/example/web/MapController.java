package org.example.web;


import org.example.service.GalleryService;
import org.example.model.Gallery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/map")
public class MapController {
    private final GalleryService galleryService;

    public MapController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping()
    public ResponseEntity<List<Gallery>> getGalleriesForMap() {
        List<Gallery> galleries = galleryService.listAll();
        return ResponseEntity.ok(galleries);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Gallery>> searchGalleriesByCity(@RequestParam String searchText) {
        List<Gallery> galleries = galleryService.searchByCity(searchText);
        return ResponseEntity.ok(galleries);
    }
}
