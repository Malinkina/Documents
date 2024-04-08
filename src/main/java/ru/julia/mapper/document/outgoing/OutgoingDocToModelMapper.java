package ru.julia.mapper.document.outgoing;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.document.OutgoingDocument;
import ru.julia.servicelayer.model.OutgoingDocModel;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OutgoingDocToModelMapper {
    @Mapping(source = "author", target = "authorId", qualifiedByName = "employeeToUUID")
    @Mapping(source = "recipient", target = "recipientId", qualifiedByName = "employeeToUUID")
    OutgoingDocModel toModel(OutgoingDocument outgoingDocument);

    @Named("employeeToUUID")
    default UUID mapEmployee(EmployeeXml employee) {
        return employee.getId();
    }
}
