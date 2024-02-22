package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.OutgoingDocumentJPA;

import java.util.UUID;

public interface OutgoingDocumentRepository extends CrudRepository<OutgoingDocumentJPA, UUID> {
}
