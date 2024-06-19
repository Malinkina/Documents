package ru.julia.mapper.organization;

import org.mapstruct.*;
import ru.julia.orm.jpamodel.OrganizationJpa;
import ru.julia.servicelayer.model.OrganizationModel;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrganizationModelJpaMapper {
    @Mapping(source = "phoneNumbers", target = "phoneNumbers", qualifiedByName = "listPhoneNumbersToString")
    OrganizationJpa toJpa(OrganizationModel organizationModel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "phoneNumbers", target = "phoneNumbers", qualifiedByName = "listPhoneNumbersToString")
    void updateJpaFromModel(OrganizationModel organizationModel,
                            @MappingTarget OrganizationJpa organizationJpa);

    @Named("listPhoneNumbersToString")
    default String listPhoneNumbersToString(List<String> phoneNumbers) {
        return phoneNumbers.stream().map(String::trim).collect(Collectors.joining(","));
    }
}
