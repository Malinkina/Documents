package ru.julia.mapper.document.incoming;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.document.IncomingDocument;
import ru.julia.servicelayer.model.IncomingDocModel;
import ru.julia.xml.xmlmodel.EmployeeXml;

import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IncomingDocToModelMapper {
    @Mapping(source = "author", target = "authorId", qualifiedByName = "employeeToUUID")
    @Mapping(source = "recipient", target = "recipientId", qualifiedByName = "employeeToUUID")
    @Mapping(source = "sender", target = "senderId", qualifiedByName = "employeeToUUID")
    IncomingDocModel toModel(IncomingDocument incomingDocument);
    @Named("employeeToUUID")
    static UUID mapEmployee(EmployeeXml employee) {
        return employee.getId();
    }

}
