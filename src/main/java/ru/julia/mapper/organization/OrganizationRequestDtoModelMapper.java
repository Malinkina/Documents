package ru.julia.mapper.organization;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.julia.controller.dto.request.OrganizationRequestDto;
import ru.julia.servicelayer.model.OrganizationModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationRequestDtoModelMapper {
    OrganizationModel toModel(OrganizationRequestDto organizationRequestDto);
}
