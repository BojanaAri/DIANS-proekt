package com.dians.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/art-galleries")
public class MainController {

    @GetMapping()
    public String getArtGalleryPage(){
        return "master-template";
    }
}
