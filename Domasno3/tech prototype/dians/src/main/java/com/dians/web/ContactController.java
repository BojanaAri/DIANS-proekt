package com.dians.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller for handling requests related to the contact page
@Controller
@RequestMapping("/contact")
public class ContactController {

    // Handle GET requests to "/contact"
    @GetMapping
    public String getContactPage(Model model) {
        // Add an attribute to the model indicating the body content to be displayed
        model.addAttribute("bodyContent", "contact");
        // Return the name of the template to be rendered
        return "master-template";
    }
}

