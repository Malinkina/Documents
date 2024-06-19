package ru.julia.mapper.document.incoming;

import org.mapstruct.*;
import ru.julia.orm.jpamodel.IncomingDocJpa;
import ru.julia.servicelayer.model.IncomingDocModel;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IncomingDocModelJpaMapper {
    IncomingDocJpa toJpa(IncomingDocModel incomingDocModel);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateJpaFromModel(IncomingDocModel incomingDocModel, @MappingTarget IncomingDocJpa incomingDocJpa);
}
