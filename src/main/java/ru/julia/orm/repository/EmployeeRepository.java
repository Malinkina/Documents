package ru.julia.orm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.julia.orm.jpamodel.EmployeeJpa;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<EmployeeJpa, UUID> {
    @Query("select e from EmployeeJpa e join UserJpa u on u.employeeId = e.id where u.username = ?1 ")
    EmployeeJpa findByUsername(@Param("username")String username);
}
