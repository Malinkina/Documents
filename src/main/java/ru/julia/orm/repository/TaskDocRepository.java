package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.TaskDocJpa;

import java.util.UUID;

public interface TaskDocRepository extends CrudRepository<TaskDocJpa, UUID> {
}
