
package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.DepartmentResponseDto;
import ru.julia.mapper.department.DepartmentJpaResponseDtoMapper;
import ru.julia.mapper.department.DepartmentModelJpaMapper;
import ru.julia.orm.jpamodel.DepartmentJpa;
import ru.julia.orm.jpamodel.OrganizationJpa;
import ru.julia.orm.repository.DepartmentRepository;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.servicelayer.model.DepartmentModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class DepartmentService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentJpaResponseDtoMapper departmentJpaResponseDtoMapper;

    @Autowired
    private DepartmentModelJpaMapper modelJpaMapper;

    public void create(DepartmentModel departmentModel) {
        UUID organizationId = departmentModel.getOrganizationId();
        OrganizationJpa organizationJpa = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new RuntimeException(
                        "Organization with id %s not found".formatted(organizationId))
                );
        if (departmentModel.getId() == null) {
            departmentModel.setId(UUID.randomUUID());
        }
        DepartmentJpa departmentJpa = modelJpaMapper.toJpa(departmentModel);
        departmentJpa.setOrganizationJpa(organizationJpa);
        departmentRepository.save(departmentJpa);
    }

    public DepartmentResponseDto read(UUID id) {
        Optional<DepartmentJpa> departmentJpa = departmentRepository.findById(id);
        return departmentJpa.map(
                department -> departmentJpaResponseDtoMapper.toResponseDto(department))
                .orElseThrow(() -> new RuntimeException("Department with id %s not found".formatted(id)));
    }

    public List<DepartmentResponseDto> readAll() {
        List<DepartmentJpa> departmentsJpa = (List<DepartmentJpa>) departmentRepository.findAll();
        List<DepartmentResponseDto> departmentResponseDtos = new ArrayList<>();
        departmentsJpa.forEach(
                departmentJpa -> departmentResponseDtos.add(departmentJpaResponseDtoMapper.toResponseDto(departmentJpa))
        );
        return departmentResponseDtos;
    }

    public void update(UUID id, DepartmentModel departmentModel) {
        DepartmentJpa existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department with id %s not found".formatted(id)));
        modelJpaMapper.updateDepartmentJpaFromModel(departmentModel, existingDepartment);
        departmentRepository.save(existingDepartment);
    }

    public void delete(UUID id) {
        departmentRepository.deleteById(id);
    }
}

