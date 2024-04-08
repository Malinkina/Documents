package ru.julia.mapper.department;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.controller.dto.response.DepartmentResponseDto;
import ru.julia.orm.jpamodel.DepartmentJpa;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentJpaResponseDtoMapper {
    String DELIMITER = ",";
    @Mapping(source = "phoneNumbers", target = "phoneNumbers", qualifiedByName = "stringPhoneNumbersToList")
    DepartmentResponseDto toResponseDto(DepartmentJpa departmentJpa);
    @Named("stringPhoneNumbersToList")
    default List<String> stringPhoneNumbersToList(String phoneNumbers) {
        if (phoneNumbers == null) {
            return List.of();
        }
        String[] splitPhoneNumbers = phoneNumbers.split(DELIMITER);
        return Arrays.stream(splitPhoneNumbers).map(String::trim).toList();
    }
}
