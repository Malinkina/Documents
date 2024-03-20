package ru.julia.mapper.document.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.document.TaskDocument;
import ru.julia.servicelayer.model.TaskDocModel;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskDocToModelMapper {
    @Mapping(source = "author", target = "authorId", qualifiedByName = "employeeToUUID")
    @Mapping(source = "responsibleExecutive", target = "responsibleExecutiveId", qualifiedByName = "employeeToUUID")
    @Mapping(source = "controller", target = "controllerId", qualifiedByName = "employeeToUUID")
    TaskDocModel toModel(TaskDocument taskDocument);

    @Named("employeeToUUID")
    static UUID mapEmployee(EmployeeXml employee) {
        return employee.getId();
    }
}
