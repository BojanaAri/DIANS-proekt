package com.dians.web;

import com.dians.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/art-galleries")
public class MainController {

    private final GalleryService galleryService;

    public MainController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping()
    public String getArtGalleryPage(Model model){
        model.addAttribute("bodyContent", "home");
        model.addAttribute("galleries", galleryService.listAll());
        return "master-template";
    }


}
