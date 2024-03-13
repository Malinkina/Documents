package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.PositionJpa;

import java.util.UUID;

public interface PositionRepository extends CrudRepository<PositionJpa, UUID> {
}
