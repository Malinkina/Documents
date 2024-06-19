package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.UserJpa;
import ru.julia.orm.repository.UserRepository;

import java.util.UUID;

@Component
public class UserService {
    @Autowired
    private UserRepository repository;
    public UUID create(UserJpa userJpa) {
        repository.save(userJpa);
        return userJpa.getId();
    }
}
