package ru.julia.mapper.document.task;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.controller.dto.request.TaskDocRequestDto;
import ru.julia.servicelayer.model.TaskDocModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskDocRequestDtoModelMapper {
    TaskDocModel toModel(TaskDocRequestDto taskDocRequestDto);
}
