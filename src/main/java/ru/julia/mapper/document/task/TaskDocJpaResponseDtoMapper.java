package ru.julia.mapper.document.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.dto.response.TaskDocResponseDto;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.TaskDocJpa;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskDocJpaResponseDtoMapper {
    @Mapping(source = "controller", target = "controller", qualifiedByName = "employeeToString")
    @Mapping(source = "responsibleExecutive", target = "responsibleExecutive", qualifiedByName = "employeeToString")
    @Mapping(source = "author", target = "author", qualifiedByName = "employeeToString")
    TaskDocResponseDto toResponseDto(TaskDocJpa taskDocJpa);

    @Named("employeeToString")
    static String mapAuthor(EmployeeJpa employee) {
        return employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic();
    }
}
