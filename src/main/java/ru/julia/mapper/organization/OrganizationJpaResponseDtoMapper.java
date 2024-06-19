package ru.julia.mapper.organization;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.controller.dto.response.OrganizationResponseDto;
import ru.julia.orm.jpamodel.OrganizationJpa;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationJpaResponseDtoMapper {

    String DELIMITER = ",";

    @Mapping(source = "phoneNumbers", target = "phoneNumbers", qualifiedByName = "stringPhoneNumbersToList")
    OrganizationResponseDto toResponseDto(OrganizationJpa organizationJpa);

    @Named("stringPhoneNumbersToList")
    default List<String> stringPhoneNumbersToList(String phoneNumbers) {
        if (phoneNumbers == null) {
            return List.of();
        }
        String[] splitPhoneNumbers = phoneNumbers.split(DELIMITER);
        return Arrays.stream(splitPhoneNumbers).map(String::trim).toList();
    }
}