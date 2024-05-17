package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.RoleJpa;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<RoleJpa, UUID> {
}
