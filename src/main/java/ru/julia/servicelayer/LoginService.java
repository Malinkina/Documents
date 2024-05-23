package ru.julia.servicelayer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import ru.julia.controller.LoginController;

@Component
public class LoginService {
    public void login(LoginController.LoginRequest loginRequest,
                       HttpServletRequest request) {
        try {
            request.login(loginRequest.username(), loginRequest.password());
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
