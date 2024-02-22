package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.JPAOutgoingDocument;

import java.util.UUID;

public interface OutgoingDocumentRepository extends CrudRepository<JPAOutgoingDocument, UUID> {
}
