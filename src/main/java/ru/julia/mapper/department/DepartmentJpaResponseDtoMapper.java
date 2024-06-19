package ru.julia.mapper.department;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.dto.response.DepartmentResponseDto;
import ru.julia.orm.jpamodel.DepartmentJpa;

import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentJpaResponseDtoMapper {
    @Mapping(source = "phoneNumbers", target = "phoneNumbers", qualifiedByName = "stringPhoneNumbersToList")
    DepartmentResponseDto toResponseDto(DepartmentJpa departmentJpa);
    @Named("stringPhoneNumbersToList")
    static List<String> stringPhoneNumbersToList(String phoneNumbers) {
        return Arrays.asList(phoneNumbers.split(","));
    }
}
