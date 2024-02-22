package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.EmployeeJPA;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<EmployeeJPA, UUID> {
}
