package ru.julia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.julia.mapper.user.UserJpaModelMapper;
import ru.julia.orm.jpamodel.UserJpa;
import ru.julia.orm.repository.UserRepository;
import ru.julia.servicelayer.model.UserModel;

@Component
public class AppAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserJpaModelMapper mapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserJpa userJpa = repo.findByUsername(username);
        UserModel userModel = mapper.toModel(userJpa);
        if (username.equals(userModel.getUsername()) && encoder.matches(password, userModel.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, userModel.getAuthorities());
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
