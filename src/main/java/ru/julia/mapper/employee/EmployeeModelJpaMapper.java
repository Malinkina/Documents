package ru.julia.mapper.employee;

import org.mapstruct.*;
import ru.julia.orm.jpamodel.EmployeeJpa;
import ru.julia.servicelayer.model.EmployeeModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeModelJpaMapper {
    EmployeeJpa toJpa(EmployeeModel employeeModel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateJpaFromModel(EmployeeModel employeeModel,
                            @MappingTarget EmployeeJpa employeeJpa);
}
