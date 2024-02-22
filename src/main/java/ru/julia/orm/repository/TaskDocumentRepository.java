package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.TaskDocumentJPA;

import java.util.UUID;

public interface TaskDocumentRepository extends CrudRepository<TaskDocumentJPA, UUID> {
}
