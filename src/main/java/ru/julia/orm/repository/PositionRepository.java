package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.PositionJPA;

import java.util.UUID;

public interface PositionRepository extends CrudRepository<PositionJPA, UUID> {
}
