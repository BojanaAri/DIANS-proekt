package com.dians;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DiansApplication {

    // Main method to start the Spring Boot application
    public static void main(String[] args) {
        SpringApplication.run(DiansApplication.class, args);
    }

    // Bean definition for a PasswordEncoder (BCryptPasswordEncoder)
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
