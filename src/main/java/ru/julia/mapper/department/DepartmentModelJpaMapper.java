package ru.julia.mapper.department;

import org.mapstruct.*;
import ru.julia.orm.jpamodel.DepartmentJpa;
import ru.julia.servicelayer.model.DepartmentModel;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentModelJpaMapper {
    @Mapping(source = "phoneNumbers", target = "phoneNumbers", qualifiedByName = "listPhoneNumbersToString")
    DepartmentJpa toJpa(DepartmentModel departmentModel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "phoneNumbers", target = "phoneNumbers", qualifiedByName = "listPhoneNumbersToString")
    void updateJpaFromModel(DepartmentModel departmentModel,
                            @MappingTarget DepartmentJpa departmentJpa);

    @Named("listPhoneNumbersToString")
    default String listPhoneNumbersToString(List<String> phoneNumbers) {
        return String.join(",", phoneNumbers);
    }
}
