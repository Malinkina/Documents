package ru.julia.mapper.organization;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.dto.response.OrganizationResponseDto;
import ru.julia.orm.jpamodel.OrganizationJpa;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationJpaResponseDtoMapper {
    @Mapping(source = "phoneNumbers", target = "phoneNumbers", qualifiedByName = "stringPhoneNumbersToList")
    OrganizationResponseDto toResponseDto(OrganizationJpa organizationJpa);

    @Named("stringPhoneNumbersToList")
    static List<String> stringPhoneNumbersToList(String phoneNumbers) {
        return Arrays.asList(phoneNumbers.split(","));
    }
}
