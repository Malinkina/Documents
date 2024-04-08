package ru.julia.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.controller.dto.request.EmployeeRequestDto;
import ru.julia.servicelayer.model.EmployeeModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeRequestDtoModelMapper {
    EmployeeModel toModel(EmployeeRequestDto employeeRequestDto);
}
