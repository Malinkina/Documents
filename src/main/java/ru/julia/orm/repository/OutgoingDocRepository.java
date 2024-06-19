package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.OutgoingDocJpa;

import java.util.UUID;

public interface OutgoingDocRepository extends CrudRepository<OutgoingDocJpa, UUID> {
}
