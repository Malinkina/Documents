package ru.julia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.julia.mapper.user.UserJpaModelMapper;
import ru.julia.orm.jpamodel.UserJpa;
import ru.julia.orm.repository.UserRepository;
import ru.julia.servicelayer.model.UserModel;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AppSecurityConfig {
    @Autowired
    private UserJpaModelMapper mapper;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .anonymous(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.requestMatchers("/login").permitAll()
                        .anyRequest().authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, AppAuthenticationProvider provider) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(provider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            UserJpa userJpa = userRepo.findByUsername(username);
            UserModel userModel = mapper.toModel(userJpa);
            if (userJpa != null) {
                return userModel;
            }
            throw new UsernameNotFoundException("User not found");
        };
    }
}
