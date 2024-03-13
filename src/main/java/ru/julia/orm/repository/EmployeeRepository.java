package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.EmployeeJpa;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<EmployeeJpa, UUID> {
}
