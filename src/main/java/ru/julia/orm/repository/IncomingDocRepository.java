package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.IncomingDocJpa;

import java.util.UUID;

public interface IncomingDocRepository extends CrudRepository<IncomingDocJpa, UUID> {
}
