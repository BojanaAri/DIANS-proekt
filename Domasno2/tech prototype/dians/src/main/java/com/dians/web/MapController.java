package com.dians.web;


import com.dians.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {
    private final GalleryService galleryService;

    public MapController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }


    @GetMapping()
    public String getMapPage(Model model){
        model.addAttribute("bodyContent", "map");
        model.addAttribute("galleries", galleryService.listAll());
        return "master-template";
    }
}
