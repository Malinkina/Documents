package ru.julia.mapper.document.task;

import org.mapstruct.*;
import ru.julia.orm.jpamodel.TaskDocJpa;
import ru.julia.servicelayer.model.TaskDocModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskDocModelJpaMapper {
    TaskDocJpa toJpa(TaskDocModel taskDocModel);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateJpaFromModel(TaskDocModel taskDocModel, @MappingTarget TaskDocJpa taskDocJpa);
}
