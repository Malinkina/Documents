package ru.julia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.DepartmentJPA;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.orm.jpamodel.OrganizationJPA;
import ru.julia.orm.jpamodel.PositionJPA;
import ru.julia.orm.repository.DepartmentRepository;
import ru.julia.orm.repository.EmployeeRepository;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.orm.repository.PositionRepository;
import ru.julia.service.mapper.EmployeeMapper;
import ru.julia.service.modelforservice.EmployeeModel;

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
    private EmployeeMapper mapper;

    public void create(EmployeeModel employeeModel) {
        UUID organizationId = employeeModel.getOrganizationId();
        OrganizationJPA organizationJPA = organizationRepository.findById(organizationId)
                        .orElseThrow(() -> new RuntimeException("Organization with id " + organizationId + " not found"));
        UUID departmentId = employeeModel.getDepartmentId();
        DepartmentJPA departmentJPA = departmentRepository.findById(departmentId)
                        .orElseThrow(() -> new RuntimeException("Department with id " + departmentId + " not found"));
        UUID positionId = employeeModel.getPositionId();
        PositionJPA positionJPA = positionRepository.findById(positionId)
                        .orElseThrow(() -> new RuntimeException("Position with id " + positionId + " not found"));
        EmployeeJPA employeeJPA = mapper.employeeModelToJpaEmployee(employeeModel);
        employeeJPA.setOrganization(organizationJPA);
        employeeJPA.setDepartment(departmentJPA);
        employeeJPA.setPosition(positionJPA);
        employeeRepository.save(employeeJPA);
    }

    public Optional<EmployeeJPA> read(UUID id) {
        return employeeRepository.findById(id);
    }

    public List<EmployeeJPA> readAll() {
        return (List<EmployeeJPA>) employeeRepository.findAll();
    }

    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }
}

