package ru.julia.servicelayer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ru.julia.controller.LoginController;

import java.security.Principal;

@Component
public class LoginService {
    public void login(LoginController.LoginRequest loginRequest,
                       HttpServletRequest request,
                       Principal principal) {
        try {
            request.login(loginRequest.username(), loginRequest.password());
            Authentication authentication = (Authentication) principal;
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
