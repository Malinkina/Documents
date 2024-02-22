
package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.JPADepartment;
import ru.julia.orm.repository.DepartmentRepository;
import ru.julia.service.mapper.DepartmentMapper;
import ru.julia.service.modelforservice.DepartmentModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentMapper mapper;

    public void create(DepartmentModel departmentModel) {
        departmentRepository.save(mapper.departmentModelToDepartmentJpa(departmentModel));
    }

    public Optional<JPADepartment> read(UUID id) {
        return departmentRepository.findById(id);
    }

    public List<JPADepartment> readAll() {
        return (List<JPADepartment>) departmentRepository.findAll();
    }

    public void delete(UUID id) {
        departmentRepository.deleteById(id);
    }
}

