package ru.julia.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.julia.servicelayer.LoginService;

@RestController
@AllArgsConstructor
public class LoginController {
    private final LoginService service;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(@RequestBody LoginRequest loginRequest,
                      HttpServletRequest request) {
        service.login(loginRequest, request);
    }
    public record LoginRequest(String username, String password) {
    }
}
