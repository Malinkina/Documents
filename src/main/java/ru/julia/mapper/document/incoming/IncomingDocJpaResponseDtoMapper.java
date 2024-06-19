package ru.julia.mapper.document.incoming;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.dto.response.IncomingDocResponseDto;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.IncomingDocJpa;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IncomingDocJpaResponseDtoMapper {
    @Mapping(source = "author", target = "author", qualifiedByName = "employeeToString")
    @Mapping(source = "recipient", target = "recipient", qualifiedByName = "employeeToString")
    @Mapping(source = "sender", target = "sender", qualifiedByName = "employeeToString")
    IncomingDocResponseDto toResponseDto(IncomingDocJpa incomingDocJpa);
    @Named("employeeToString")
    static String mapAuthor(EmployeeJpa employee) {
        return employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic();
    }
}
