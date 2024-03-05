
package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.DepartmentJPA;
import ru.julia.orm.jpamodel.OrganizationJPA;
import ru.julia.orm.repository.DepartmentRepository;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.service.mapper.DepartmentMapper;
import ru.julia.service.modelforservice.DepartmentModel;

import java.util.Optional;
import java.util.UUID;

@Component
public class DepartmentService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentMapper mapper;

    public void create(DepartmentModel departmentModel) {
        UUID organizationId = departmentModel.getOrganizationId();
        OrganizationJPA organizationJPA = organizationRepository.findById(organizationId)
                .orElseThrow(()-> new RuntimeException(
                        "Organization with id " + organizationId + " not found")
                );
        DepartmentJPA departmentJPA = mapper.departmentModelToDepartmentJpa(departmentModel);
        departmentJPA.setOrganization(organizationJPA);
        departmentRepository.save(departmentJPA);
    }

    public Optional<DepartmentJPA> read(UUID id) {
        return departmentRepository.findById(id);
    }

    public Iterable<DepartmentJPA> readAll() {
        return departmentRepository.findAll();
    }

    public void delete(UUID id) {
        departmentRepository.deleteById(id);
    }
}

