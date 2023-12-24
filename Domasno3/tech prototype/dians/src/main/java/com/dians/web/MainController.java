package com.dians.web;

import com.dians.model.Gallery;
import com.dians.service.GalleryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/art-galleries","/"})
public class MainController {

    private final GalleryService galleryService;

    public MainController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping()
    public String getArtGalleryPage(Model model){
        model.addAttribute("bodyContent", "home");
        model.addAttribute("galleries", galleryService.listAll());
        model.addAttribute("show_search", false);
        return "master-template";
    }

    @GetMapping("/access_denied")
    public String getAccessDeniedPage(Model model){
        model.addAttribute("bodyContent", "access-denied");
        return "master-template";
    }

    @PostMapping()
    public String search(@RequestParam String searchText, Model model)
    {
        model.addAttribute("bodyContent", "home");
        model.addAttribute("galleries", galleryService.search(searchText));
        model.addAttribute("show_search", true);

        return "master-template";
    }


}
