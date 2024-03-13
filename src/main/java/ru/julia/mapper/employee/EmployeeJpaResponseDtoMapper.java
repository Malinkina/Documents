package ru.julia.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.dto.response.EmployeeResponseDto;
import ru.julia.orm.jpamodel.EmployeeJpa;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeJpaResponseDtoMapper {
    EmployeeResponseDto toResponseDto(EmployeeJpa employeeJpa);
}
