package ru.julia.servicelayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.dto.response.EmployeeResponseDto;
import ru.julia.mapper.employee.EmployeeJpaResponseDtoMapper;
import ru.julia.mapper.employee.EmployeeModelJpaMapper;
import ru.julia.orm.jpamodel.DepartmentJpa;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.OrganizationJpa;
import ru.julia.orm.jpamodel.PositionJpa;
import ru.julia.orm.repository.DepartmentRepository;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.orm.repository.PositionRepository;
import ru.julia.servicelayer.model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EmployeeService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeModelJpaMapper modelJpaMapper;
    @Autowired
    private EmployeeJpaResponseDtoMapper jpaResponseDtoMapper;

    public void create(EmployeeModel employeeModel) {
        UUID organizationId = employeeModel.getOrganizationId();
        OrganizationJpa organizationJpa = organizationRepository.findById(organizationId)
                        .orElseThrow(() -> new RuntimeException(
                                "Organization with id %s not found".formatted(organizationId))
                        );
        UUID departmentId = employeeModel.getDepartmentId();
        DepartmentJpa departmentJpa = departmentRepository.findById(departmentId)
                        .orElseThrow(() -> new RuntimeException(
                                "Department with id %s not found".formatted(departmentId))
                        );
        UUID positionId = employeeModel.getPositionId();
        PositionJpa positionJpa = positionRepository.findById(positionId)
                        .orElseThrow(() -> new RuntimeException(
                                "Position with id %s not found".formatted(positionId))
                        );
        if (employeeModel.getId() == null) {
            employeeModel.setId(UUID.randomUUID());
        }
        EmployeeJpa employeeJpa = modelJpaMapper.toJpa(employeeModel);
        employeeJpa.setOrganizationJpa(organizationJpa);
        employeeJpa.setDepartmentJpa(departmentJpa);
        employeeJpa.setPositionJpa(positionJpa);
        employeeRepository.save(employeeJpa);
    }

    public EmployeeResponseDto read(UUID id) {
        Optional<EmployeeJpa> employeeJPA = employeeRepository.findById(id);
        return employeeJPA.map(employeeJpa -> jpaResponseDtoMapper.toResponseDto(employeeJpa))
                .orElseThrow(() -> new RuntimeException("Employee with id %s not found".formatted(id)));
    }

    public List<EmployeeResponseDto> readAll() {
        List<EmployeeJpa> employeeJPA = (List<EmployeeJpa>) employeeRepository.findAll();
        List<EmployeeResponseDto> employeeResponseDtos = new ArrayList<>();
        employeeJPA.forEach(employeeJpa -> employeeResponseDtos.add(jpaResponseDtoMapper.toResponseDto(employeeJpa)));
        return employeeResponseDtos;
    }

    public void update(UUID id, EmployeeModel employeeModel) {
        EmployeeJpa existingEmployeeJpa = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id %s not found".formatted(id)));
        modelJpaMapper.updateJpaFromModel(employeeModel, existingEmployeeJpa);
        employeeRepository.save(existingEmployeeJpa);
    }

    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }
}

