package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.DepartmentJpa;

import java.util.UUID;

public interface DepartmentRepository extends CrudRepository<DepartmentJpa, UUID> {
}
