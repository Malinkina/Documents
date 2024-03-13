package ru.julia.mapper.organization;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.servicelayer.model.OrganizationModel;
import ru.julia.xml.xmlmodel.OrganizationXml;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationXmlModelMapper {
    OrganizationModel toModel(OrganizationXml organizationXml);
}
