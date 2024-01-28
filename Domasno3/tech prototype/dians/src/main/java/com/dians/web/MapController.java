package com.dians.web;


import com.dians.model.Gallery;
import com.dians.repository.jpa.JpaGalleryRepository;
import com.dians.service.GalleryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        List<Gallery> galleryList = galleryService.listAll();

        model.addAttribute("galleries", galleryList);
        return "master-template";
    }
    @PostMapping()
    public String search(@RequestParam String searchText, Model model)
    {
        model.addAttribute("bodyContent", "map");
        model.addAttribute("galleries", galleryService.searchByCity(searchText));
     return "redirect:/map";
    }
}
