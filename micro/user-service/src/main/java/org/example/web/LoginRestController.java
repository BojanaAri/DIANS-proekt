package org.example.web;

import com.dians.model.exceptions.InvalidUserCredentialsException;
import jakarta.servlet.http.HttpServletRequest;
import org.example.model.User;
import org.example.service.AuthService;
import org.springframework.core.ResolvableType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginRestController {

    private final AuthService authService;
    private final ClientRegistrationRepository clientRegistrationRepository;
    private static String authURL = "oauth2/authorization";
    Map<String, String> oauth2AuthenticationUrls
            = new HashMap<>();

    public LoginRestController(AuthService authService, ClientRegistrationRepository clientRegistrationRepository) {
        this.authService = authService;
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    @GetMapping
    public ResponseEntity<Object> getLoginPage() {
        Map<String, Object> response = new HashMap<>();
        response.put("bodyContent", "login");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/oauth2")
    public ResponseEntity<Object> getOathLoginPage() {
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }

        clientRegistrations.forEach(clientRegistration -> String.format("%s %s %s", clientRegistration.getClientName(), clientRegistration.getRegistrationId(), clientRegistration.getProviderDetails()));

        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientName(),
                        authURL + "/" + registration.getRegistrationId()));

        Map<String, Object> response = new HashMap<>();
        response.put("urls", oauth2AuthenticationUrls);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        response.put("bodyContent", "login");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Object> login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        try {
            User user = authService.login(username, password);
            request.getSession().setAttribute("user", user);
            return ResponseEntity.ok("redirect:/profile");
        } catch (InvalidUserCredentialsException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("hasError", true);
            response.put("error", e.getMessage());
            response.put("bodyContent", "login");
            return ResponseEntity.ok(response);
        }
    }
}