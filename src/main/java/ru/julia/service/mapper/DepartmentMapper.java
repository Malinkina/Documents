package ru.julia.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.JPADepartment;
import ru.julia.orm.repository.OrganizationRepository;
import ru.julia.service.modelforservice.DepartmentModel;
import ru.julia.xml.xmlmodel.XMLDepartment;

import java.util.UUID;

@Component
public class DepartmentMapper {
    @Autowired
    private OrganizationRepository organizationRepository;
    public DepartmentModel xmlDepartmentToDepartmentModel(XMLDepartment xmlDepartment) {
        DepartmentModel departmentModel = new DepartmentModel();
        departmentModel.setId(UUID.fromString(xmlDepartment.getId()));
        departmentModel.setFullName(xmlDepartment.getFullName());
        departmentModel.setShortName(xmlDepartment.getShortName());
        departmentModel.setManager(xmlDepartment.getManager());
        departmentModel.setContactPhoneNumbers(xmlDepartment.getContactPhoneNumbers().toString());
        departmentModel.setOrganizationId(xmlDepartment.getOrganizationId());
        return departmentModel;
    }
    public JPADepartment departmentModelToDepartmentJpa(DepartmentModel departmentModel) {
        JPADepartment jpaDepartment = new JPADepartment();
        jpaDepartment.setId(departmentModel.getId());
        jpaDepartment.setFullName(departmentModel.getFullName());
        jpaDepartment.setShortName(departmentModel.getShortName());
        jpaDepartment.setManager(departmentModel.getManager());
        jpaDepartment.setContactPhoneNumbers(departmentModel.getContactPhoneNumbers());
        jpaDepartment.setOrganization(organizationRepository.findById(UUID.fromString(departmentModel.getOrganizationId())).get());
        return jpaDepartment;
    }
}
