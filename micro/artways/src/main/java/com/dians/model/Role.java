package com.dians.model;

import org.springframework.security.core.GrantedAuthority;

// Enum representing user roles
public enum Role implements GrantedAuthority {
    // Two roles: ROLE_USER and ROLE_ADMIN
    ROLE_USER,
    ROLE_ADMIN;

    // Method from GrantedAuthority interface to get the authority (role) name
    @Override
    public String getAuthority() {
        return name();
    }
}

