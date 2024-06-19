package ru.julia.mapper.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import ru.julia.controller.dto.response.EmployeeResponseDto;
import ru.julia.orm.jpamodel.DepartmentJpa;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.orm.jpamodel.OrganizationJpa;
import ru.julia.orm.jpamodel.PositionJpa;

import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeJpaResponseDtoMapper {
    @Mapping(source = "organizationJpa", target = "organizationId", qualifiedByName = "getOrgId")
    @Mapping(source = "departmentJpa", target = "departmentId", qualifiedByName = "getDepId")
    @Mapping(source = "positionJpa", target = "positionId", qualifiedByName = "getPosId")
    EmployeeResponseDto toResponseDto(EmployeeJpa employeeJpa);

    @Named("getOrgId")
    default UUID getOrganizationIdFromOrganizationJpa(OrganizationJpa organizationJpa) {
        return organizationJpa.getId();
    }

    @Named("getDepId")
    default UUID getDepartmentIdFromDepartmentJpa(DepartmentJpa departmentJpa) {
        return departmentJpa.getId();
    }

    @Named("getPosId")
    default UUID getPositionIdFromPositionJpa(PositionJpa positionJpa) {
        return positionJpa.getId();
    }
}
