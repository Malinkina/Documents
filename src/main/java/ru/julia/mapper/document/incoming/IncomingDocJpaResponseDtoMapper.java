package ru.julia.mapper.document.incoming;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.dto.response.IncomingDocResponseDto;
import ru.julia.orm.jpamodel.IncomingDocJpa;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IncomingDocJpaResponseDtoMapper {
    IncomingDocResponseDto toResponseDto(IncomingDocJpa incomingDocJpa);
}
