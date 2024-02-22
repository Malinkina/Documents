package ru.julia.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.JPAEmployee;
import ru.julia.orm.repository.DepartmentRepository;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.orm.repository.PositionRepository;
import ru.julia.service.modelforservice.EmployeeModel;
import ru.julia.xml.xmlmodel.XMLEmployee;

import java.util.UUID;

@Component
public class EmployeeMapper {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private PositionRepository positionRepository;
    public EmployeeModel xmlEmployeeToEmployeeModel(XMLEmployee xmlEmployee) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(UUID.fromString(xmlEmployee.getId()));
        employeeModel.setSurname(xmlEmployee.getSurname());
        employeeModel.setName(xmlEmployee.getName());
        employeeModel.setPatronymic(xmlEmployee.getPatronymic());
        employeeModel.setPhoto(xmlEmployee.getPhoto());
        employeeModel.setDateOfBirth(xmlEmployee.getDateOfBirth());
        employeeModel.setPhoneNumber(xmlEmployee.getPhoneNumber());
        employeeModel.setDepartmentId(xmlEmployee.getDepartmentId());
        employeeModel.setOrganizationId(xmlEmployee.getOrganizationId());
        employeeModel.setPositionId(xmlEmployee.getPositionId());
        return employeeModel;
    }

    public JPAEmployee employeeModelToJpaEmployee (EmployeeModel employeeModel) {
        JPAEmployee jpaEmployee = new JPAEmployee();
        jpaEmployee.setId(employeeModel.getId());
        jpaEmployee.setSurname(employeeModel.getSurname());
        jpaEmployee.setName(employeeModel.getName());
        jpaEmployee.setPatronymic(employeeModel.getPatronymic());
        jpaEmployee.setPhoto(employeeModel.getPhoto());
        jpaEmployee.setDateOfBirth(employeeModel.getDateOfBirth());
        jpaEmployee.setPhoneNumber(employeeModel.getPhoneNumber());
        jpaEmployee.setOrganization(organizationRepository.findById(UUID.fromString(employeeModel.getOrganizationId())).get());
        jpaEmployee.setDepartment(departmentRepository.findById(UUID.fromString(employeeModel.getDepartmentId())).get());
        jpaEmployee.setPosition(positionRepository.findById(UUID.fromString(employeeModel.getPositionId())).get());
        return jpaEmployee;
    }
}
