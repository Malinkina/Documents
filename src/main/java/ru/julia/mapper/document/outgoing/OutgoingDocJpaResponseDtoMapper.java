package ru.julia.mapper.document.outgoing;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.dto.response.OutgoingDocResponseDto;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.OutgoingDocJpa;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OutgoingDocJpaResponseDtoMapper {
    @Mapping(source = "author", target = "author", qualifiedByName = "employeeToString")
    @Mapping(source = "recipient", target = "recipient", qualifiedByName = "employeeToString")
    OutgoingDocResponseDto toResponseDto(OutgoingDocJpa outgoingDocJpa);
    @Named("employeeToString")
    static String mapAuthor(EmployeeJpa employee) {
        return employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic();
    }
}
