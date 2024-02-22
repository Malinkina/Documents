package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.DepartmentJPA;

import java.util.UUID;

public interface DepartmentRepository extends CrudRepository<DepartmentJPA, UUID> {
}
