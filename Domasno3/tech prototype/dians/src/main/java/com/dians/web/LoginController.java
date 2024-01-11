package com.dians.web;

import com.dians.model.User;
import com.dians.model.exceptions.InvalidUserCredentialsException;
import com.dians.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

// Controller for handling user login-related requests
@Controller
@RequestMapping("/login")
public class LoginController {

    // Service for handling authentication logic
    private final AuthService authService;

    // Constructor to inject the authentication service
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    // Handle GET requests to "/login"
    @GetMapping
    public String getLoginPage(Model model) {
        // Add an attribute to the model indicating the body content to be displayed
        model.addAttribute("bodyContent", "login");
        // Return the name of the template to be rendered
        return "master-template";
    }

    // Handle POST requests to "/login"
    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;

        try {
            // Attempt to log in with the provided username and password
            user = authService.login(request.getParameter("username"), request.getParameter("password"));
            // If successful, set the body content to "home"
            model.addAttribute("bodyContent", "home");
            // Return the name of the template to be rendered
            return "master-template";
        } catch (InvalidUserCredentialsException e) {
            // If login fails, set the body content back to "login"
            model.addAttribute("bodyContent", "login");
            // Return the name of the template to be rendered
            return "master-template";
        }
    }
}
