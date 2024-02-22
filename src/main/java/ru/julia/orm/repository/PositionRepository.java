package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.JPAPosition;

import java.util.UUID;

public interface PositionRepository extends CrudRepository<JPAPosition, UUID> {
}
