package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.JPAIncomingDocument;

import java.util.UUID;

public interface IncomingDocumentRepository extends CrudRepository<JPAIncomingDocument, UUID> {
}
