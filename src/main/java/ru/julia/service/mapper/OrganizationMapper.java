package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.orm.jpamodel.OrganizationJPA;
import ru.julia.service.modelforservice.OrganizationModel;
import ru.julia.xml.xmlmodel.OrganizationXML;
@Component
public class OrganizationMapper {
    public OrganizationModel xmlOrgToOrgModel(OrganizationXML organizationXML) {
        OrganizationModel.OrganizationModelBuilder builder = new OrganizationModel.OrganizationModelBuilder();
        return builder.id(organizationXML.getId())
                .fullName(organizationXML.getFullName())
                .shortName(organizationXML.getShortName())
                .manager(organizationXML.getManager())
                .phoneNumbers(organizationXML.getContactPhoneNumbers())
                .build();
    }
    public OrganizationJPA orgModelToOrgJpa(OrganizationModel organizationModel) {
        OrganizationJPA.OrganizationJPABuilder builder = new OrganizationJPA.OrganizationJPABuilder();
        return builder
                .id(organizationModel.getId())
                .fullName(organizationModel.getFullName())
                .shortName(organizationModel.getShortName())
                .manager(organizationModel.getManager())
                .phoneNumbers(organizationModel.getPhoneNumbers().toString())
                .build();
    }


}
