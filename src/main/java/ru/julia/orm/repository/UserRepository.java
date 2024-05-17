package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.UserJpa;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserJpa, UUID> {
    UserJpa findByUsername(String username);
}
