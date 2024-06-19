package ru.julia.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.servicelayer.model.EmployeeModel;
import ru.julia.xml.xmlmodel.EmployeeXml;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeXmlModelMapper {
    EmployeeModel toModel(EmployeeXml employeeXml);
}
