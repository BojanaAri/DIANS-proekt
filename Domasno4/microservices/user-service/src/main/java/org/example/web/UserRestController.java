package org.example.web;

import org.example.model.User;
import org.example.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/profile")
public class UserRestController {

    private final AuthService authService;

    public UserRestController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<Object> getProfilePage(Model model){
        return ResponseEntity.ok("redirect:/api/login");
    }

}
