package com.dians.web;

import com.dians.model.User;
import com.dians.model.exceptions.InvalidUserCredentialsException;
import com.dians.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;
    private final ClientRegistrationRepository clientRegistrationRepository;
    private static String authURL = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls
            = new HashMap<>();

    public LoginController(AuthService authService, ClientRegistrationRepository clientRegistrationRepository) {
        this.authService = authService;
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

    @GetMapping("/oauth2")
    public String getOathLoginPage(Model model) {
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }

        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientName(),
                        authURL + "/" + registration.getRegistrationId()));
        model.addAttribute("urls", oauth2AuthenticationUrls);

        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model){
        User user = null;

        try {
            user = authService.login(request.getParameter("username"),
                                     request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/profile";
        } catch (InvalidUserCredentialsException e) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());

            model.addAttribute("bodyContent", "login");
            return "master-template";
        }
    }

}
