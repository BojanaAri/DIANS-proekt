package com.dians.web;


import com.dians.model.Gallery;
import com.dians.service.GalleryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.shaded.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/map")
public class MapController {
    private final GalleryService galleryService;

    public MapController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @GetMapping()
    public String getMapPage(Model model) {
        model.addAttribute("bodyContent", "map");

        List<Gallery> galleryList = galleryService.listAll();

        model.addAttribute("galleries", galleryList);
        model.addAttribute("show_search", false);

        return "master-template";
    }
}
