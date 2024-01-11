package com.dians.web;

import com.dians.model.exceptions.InvalidArgumentExceptions;
import com.dians.model.exceptions.PasswordDoNotMatchException;
import com.dians.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Controller for handling user registration-related requests
@Controller
@RequestMapping("/register")
public class RegisterController {

    // Service for handling user authentication and registration logic
    private final AuthService authService;

    // Constructor to inject the authentication service
    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    // Handle GET requests to "/register"
    @GetMapping
    public String getLoginPage(@RequestParam(required = false) String error, Model model) {
        // If an error is present, add error-related attributes to the model
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        // Add an attribute to the model indicating the body content to be displayed
        model.addAttribute("bodyContent", "register");
        // Return the name of the template to be rendered
        return "master-template";
    }

    // Handle POST requests to "/register"
    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           @RequestParam String name,
                           @RequestParam String surname) {
        try {
            // Attempt to register a new user with the provided information
            this.authService.register(username, password, repeatPassword, name, surname);
            // Redirect to the login page upon successful registration
            return "redirect:/login";
        } catch (InvalidArgumentExceptions | PasswordDoNotMatchException e) {
            // Redirect to the registration page with an error message if registration fails
            return "redirect:/register?error=" + e.getMessage();
        }
    }
}
