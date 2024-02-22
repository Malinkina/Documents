package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.JPADocument;

public interface DocumentRepository extends CrudRepository<JPADocument, String> {
}
