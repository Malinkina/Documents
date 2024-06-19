package ru.julia.mapper.department;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.servicelayer.model.DepartmentModel;
import ru.julia.xml.xmlmodel.DepartmentXml;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentXmlModelMapper {
    DepartmentModel toModel(DepartmentXml departmentXml);
}
