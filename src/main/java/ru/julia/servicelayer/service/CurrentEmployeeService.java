package ru.julia.servicelayer.service;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.security.CurrentUserProvider;

@Service
@AllArgsConstructor
public class CurrentEmployeeService {
    private final CurrentUserProvider userProvider;
    private final EmployeeRepository repository;

    public EmployeeJpa getCurrentUser() {
        UsernamePasswordAuthenticationToken auth = userProvider.getAuthentication();
        String username = auth.getPrincipal().toString();
        EmployeeJpa employeeJpa = repository.findByUsername(username);
        return employeeJpa;
    }
}
