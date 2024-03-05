package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.DocumentJPA;

import java.util.UUID;

public interface DocumentRepository extends CrudRepository<DocumentJPA, UUID> {
}
