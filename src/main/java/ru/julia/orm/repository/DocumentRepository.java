package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.DocumentJpa;

import java.util.UUID;

public interface DocumentRepository extends CrudRepository<DocumentJpa, UUID> {
}
