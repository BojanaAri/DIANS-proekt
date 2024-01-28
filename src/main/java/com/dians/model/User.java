package com.dians.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

    // Primary key, representing the username
    @Id
    private String username;

    // Password of the user
    private String password;

    // Name of the user
    private String name;

    // Surname of the user
    private String surname;

    // Role of the user (e.g., ROLE_USER, ROLE_ADMIN)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    // Flags for account status
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;

    // Constructors

    // No-args constructor required for JPA

    // Parameterized constructor to create a user with basic details
    public User(String username, String password, String name, String surname, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public User() {

    }

    // UserDetails interface methods

    // Get the authorities (roles) associated with the user
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    // Methods to check account status
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
