package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.EmployeeJPA;
import ru.julia.service.modelforservice.EmployeeModel;
import ru.julia.xml.xmlmodel.EmployeeXML;

@Component
public class EmployeeMapper {
    public EmployeeModel xmlEmployeeToEmployeeModel(EmployeeXML employeeXML) {
        EmployeeModel.EmployeeModelBuilder builder = new EmployeeModel.EmployeeModelBuilder();
        return builder
                .id(employeeXML.getId())
                .surname(employeeXML.getSurname())
                .name(employeeXML.getName())
                .patronymic(employeeXML.getPatronymic())
                .photo(employeeXML.getPhoto())
                .dateOfBirth(employeeXML.getDateOfBirth())
                .phoneNumber(employeeXML.getPhoneNumber())
                .organizationId(employeeXML.getOrganizationId())
                .departmentId(employeeXML.getDepartmentId())
                .positionId(employeeXML.getPositionId())
                .build();
    }

    public EmployeeJPA employeeModelToJpaEmployee (EmployeeModel employeeModel) {
        EmployeeJPA.EmployeeJpaBuilder builder = new EmployeeJPA.EmployeeJpaBuilder();
        return builder
                .id(employeeModel.getId())
                .surname(employeeModel.getSurname())
                .name(employeeModel.getName())
                .patronymic(employeeModel.getPatronymic())
                .photo(employeeModel.getPhoto())
                .dateOfBirth(employeeModel.getDateOfBirth())
                .phoneNumber(employeeModel.getPhoneNumber())
                .build();
    }
}
