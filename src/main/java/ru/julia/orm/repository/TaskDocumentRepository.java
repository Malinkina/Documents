package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.JPATaskDocument;

import java.util.UUID;

public interface TaskDocumentRepository extends CrudRepository<JPATaskDocument, UUID> {
}
