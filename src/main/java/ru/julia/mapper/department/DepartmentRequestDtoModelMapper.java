package ru.julia.mapper.department;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.dto.request.DepartmentRequestDto;
import ru.julia.servicelayer.model.DepartmentModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentRequestDtoModelMapper {
    DepartmentModel toModel(DepartmentRequestDto departmentRequestDto);
}
