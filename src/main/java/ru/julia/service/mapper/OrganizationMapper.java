package ru.julia.service.mapper;

import org.springframework.stereotype.Component;
import ru.julia.service.modelforservice.OrganizationModel;
import ru.julia.orm.jpamodel.JPAOrganization;
import ru.julia.xml.xmlmodel.XMLOrganization;

import java.util.UUID;
@Component
public class OrganizationMapper {
    public OrganizationModel xmlOrgToOrgModel(XMLOrganization xmlOrganization) {
        OrganizationModel organizationModel = new OrganizationModel();
        organizationModel.setId(UUID.fromString(xmlOrganization.getId()));
        organizationModel.setFullName(xmlOrganization.getFullName());
        organizationModel.setShortName(xmlOrganization.getShortName());
        organizationModel.setManager(xmlOrganization.getManager());
        organizationModel.setContactPhoneNumber(xmlOrganization.getContactPhoneNumbers());
        return organizationModel;
    }
    public JPAOrganization orgModelToOrgJpa(OrganizationModel organizationModel) {
        JPAOrganization jpaOrganization = new JPAOrganization();
        jpaOrganization.setId(organizationModel.getId());
        jpaOrganization.setFullName(organizationModel.getFullName());
        jpaOrganization.setShortName(organizationModel.getShortName());
        jpaOrganization.setManager(organizationModel.getManager());
        jpaOrganization.setContactPhoneNumber(organizationModel.getContactPhoneNumber().toString());
        return jpaOrganization;
    }


}
