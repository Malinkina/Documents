package ru.julia.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserProvider {
    public UsernamePasswordAuthenticationToken getAuthentication() {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();
        return auth;
    }
}
