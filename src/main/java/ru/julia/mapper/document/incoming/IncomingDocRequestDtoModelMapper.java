package ru.julia.mapper.document.incoming;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.controller.dto.request.IncomingDocRequestDto;
import ru.julia.servicelayer.model.IncomingDocModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IncomingDocRequestDtoModelMapper {
    IncomingDocModel toModel(IncomingDocRequestDto incomingDocRequestDto);
}
