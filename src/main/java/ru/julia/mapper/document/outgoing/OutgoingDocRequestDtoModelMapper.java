package ru.julia.mapper.document.outgoing;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.controller.dto.request.OutgoingDocRequestDto;
import ru.julia.servicelayer.model.OutgoingDocModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OutgoingDocRequestDtoModelMapper {
    OutgoingDocModel toModel(OutgoingDocRequestDto outgoingDocRequestDto);
}
