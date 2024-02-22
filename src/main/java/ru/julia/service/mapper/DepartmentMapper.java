package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.DepartmentJPA;
import ru.julia.service.modelforservice.DepartmentModel;
import ru.julia.xml.xmlmodel.DepartmentXML;

@Component
public class DepartmentMapper {
    public DepartmentModel xmlDepartmentToDepartmentModel(DepartmentXML departmentXML) {
        DepartmentModel.DepartmentModelBuilder builder = new DepartmentModel.DepartmentModelBuilder();
        return builder
                .id(departmentXML.getId())
                .fullName(departmentXML.getFullName())
                .shortName(departmentXML.getShortName())
                .manager(departmentXML.getManager())
                .phoneNumbers(departmentXML.getContactPhoneNumbers().toString())
                .organizationId(departmentXML.getOrganizationId())
                .build();
    }
    public DepartmentJPA departmentModelToDepartmentJpa(DepartmentModel departmentModel) {
        DepartmentJPA.DepartmentJpaBuilder builder = new DepartmentJPA.DepartmentJpaBuilder();
        return builder
                .id(departmentModel.getId())
                .fullName(departmentModel.getFullName())
                .shortName(departmentModel.getShortName())
                .manager(departmentModel.getManager())
                .phoneNumbers(departmentModel.getPhoneNumbers())
                .build();
    }
}
