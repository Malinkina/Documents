package ru.julia.orm.repository;

import org.springframework.data.repository.CrudRepository;
import ru.julia.orm.jpamodel.OrganizationJpa;

import java.util.UUID;
public interface OrganizationRepository extends CrudRepository<OrganizationJpa, UUID> {
}