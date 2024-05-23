package ru.julia.orm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.julia.orm.jpamodel.DocumentJpa;

import java.util.UUID;

public interface DocumentRepository extends CrudRepository<DocumentJpa, UUID> {
    @Query("select d from DocumentJpa d where d.regNumber = ?1")
    DocumentJpa findByRegNumber(@Param("regNumber") String regNumber);
}
