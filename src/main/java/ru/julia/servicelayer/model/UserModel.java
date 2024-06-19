package ru.julia.servicelayer.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Data
public class UserModel implements UserDetails {
    private UUID id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Collection<Privilege> authorities;

    @Override
    public Collection<Privilege> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
