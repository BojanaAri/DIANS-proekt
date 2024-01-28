package org.example.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logout")
public class LogoutRestController {
    @GetMapping("/api/logout")
    public ResponseEntity<Object> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok("redirect:/api/login");
    }

}
