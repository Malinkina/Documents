package ru.julia.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.servicelayer.model.EmployeeModel;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeXmlModelMapper {
    @Mapping(source = "dateOfBirth", target = "dateOfBirth", qualifiedByName = "parseDateFromString")
    EmployeeModel toModel(EmployeeXml employeeXml);

    @Named("parseDateFromString")
    default LocalDate parseDateFromString(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
