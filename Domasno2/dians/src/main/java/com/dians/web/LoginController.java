package com.dians.web;

import com.dians.model.User;
import com.dians.model.exceptions.InvalidUserCredentialsException;
import com.dians.service.AuthService;
import com.dians.service.AuthServiceImplementation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping
    public String getLoginPage(Model model){
        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model){
        User user = null;

        try {
            user = authService.login(request.getParameter("username"),
                                     request.getParameter("password"));
            // request.getSession().setAttribute("user", user);
            model.addAttribute("bodyContent", "home");
            return "master-template";
        } catch (InvalidUserCredentialsException e) {
//             model.addAttribute("hasError", true);
//            model.addAttribute("error", e.getMessage());
            model.addAttribute("bodyContent", "login");
            return "master-template";
        }
    }


}
